package com.bytedance.android.shopping.feed.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.MarketingBanner;
import com.bytedance.android.ec.model.response.anchorv3.MarketingTip;
import com.bytedance.android.ec.model.response.anchorv3.ProductTopicInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLiveEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InflowRespExtra;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.enumeration.GoodPriceCardOrStripType;
import com.bytedance.android.shopping.feed.enums.AutoExpandType;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.model.CartNumData;
import com.bytedance.android.shopping.feed.model.CartNumResponse;
import com.bytedance.android.shopping.feed.model.GuessULikeAdData;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.model.SaveMoneyCardMarketingInfoResponse;
import com.bytedance.android.shopping.feed.pitaya.ECProdInnerPitayaMachine;
import com.bytedance.android.shopping.feed.pitaya.ECProdInnerPitayaMachine$registerGoodPriceMessageHandler$1$1;
import com.bytedance.android.shopping.feed.pitaya.ECProdInnerPitayaMachine$registerInflowAutoExpand$1$1;
import com.bytedance.android.shopping.feed.pitaya.ECProdInnerPitayaMachine$registerProductDetailBackMessageHandler$1$1;
import com.bytedance.android.shopping.feed.pitaya.data.GoodPriceActionType;
import com.bytedance.android.shopping.feed.pitaya.data.JumpFromType;
import com.bytedance.android.shopping.feed.pitaya.data.TriggerModeType;
import com.bytedance.android.shopping.feed.repository.AnchorV3Repository;
import com.bytedance.android.shopping.feed.repository.api.GoodPriceApi;
import com.bytedance.android.shopping.feed.repository.api.InnerAdditionalApi;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.resourcecard.frequency.MallDivertShowJudge;
import com.bytedance.android.shopping.feed.resourcecard.frequency.ResourceCardFreqController;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u000f*\u0002¬\u0002\u0018\u0000 ¸\u00022\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002¹\u0002B\t¢\u0006\u0006\b¶\u0002\u0010·\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0003J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001cH\u0002J6\u0010+\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0)2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010(\u001a\u00020'H\u0002J\u001a\u0010-\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020\u00152\u0006\u0010(\u001a\u00020'H\u0002J\u001e\u00100\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00102\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0\u0010H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\u0012\u0010:\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0007J\u0010\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020?H\u0007J\u0010\u0010D\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010BJ\u001e\u0010E\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010F\u001a\u0004\u0018\u00010BJ\f\u0010H\u001a\b\u0012\u0004\u0012\u00020B0GJ\u0010\u0010J\u001a\u00020\b2\b\b\u0002\u0010I\u001a\u00020\u0006J\u000e\u0010L\u001a\u00020\b2\u0006\u0010K\u001a\u00020\rJ\u001a\u0010N\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010%2\u0006\u0010\u000b\u001a\u00020\nH\u0007J&\u0010P\u001a\u00020\b2\u0006\u0010K\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u001cJ\u0006\u0010Q\u001a\u00020\bJ\u001c\u0010S\u001a\u00020\b2\b\b\u0002\u0010R\u001a\u00020\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\nJ\u0010\u0010U\u001a\u00020\b2\b\u0010T\u001a\u0004\u0018\u00010\nJ\u0016\u0010V\u001a\u00020\b2\u0006\u0010K\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020\bJ\u000e\u0010Y\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0006J\u0014\u0010Z\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0010J\b\u0010[\u001a\u00020\u0002H\u0014J\b\u0010\\\u001a\u00020\bH\u0014J \u0010_\u001a\u00020\n2\b\u0010M\u001a\u0004\u0018\u00010%2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nJ\u000e\u0010a\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cJ\u000e\u0010b\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cJ\u0011\u0010e\u001a\u00020c2\u0006\u0010d\u001a\u00020cH\u0096\u0001J\t\u0010f\u001a\u00020\bH\u0096\u0001J\t\u0010h\u001a\u00020gH\u0096\u0001J\u0011\u0010i\u001a\u00020\b2\u0006\u0010d\u001a\u00020cH\u0096\u0001R(\u0010k\u001a\b\u0012\u0004\u0012\u00020j0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010C\u001a\b\u0012\u0004\u0012\u00020B0G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010q\u001a\u0004\bF\u0010r\"\u0004\bD\u0010sR$\u0010t\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020j0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010l\u001a\u0005\b\u0081\u0001\u0010n\"\u0005\b\u0082\u0001\u0010pR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R+\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R)\u0010\u009a\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R)\u0010 \u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010¦\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010{R,\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R,\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010q\u001a\u0005\b®\u0001\u0010r\"\u0005\b¯\u0001\u0010sR,\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b°\u0001\u0010q\u001a\u0005\b°\u0001\u0010r\"\u0005\b±\u0001\u0010sR,\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010q\u001a\u0005\b³\u0001\u0010r\"\u0005\b´\u0001\u0010sR \u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0006¢\u0006\u000e\n\u0005\bµ\u0001\u0010q\u001a\u0005\b¶\u0001\u0010rR!\u0010¸\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010G8\u0006¢\u0006\u000e\n\u0005\b¸\u0001\u0010q\u001a\u0005\b¹\u0001\u0010rR!\u0010»\u0001\u001a\t\u0012\u0005\u0012\u00030º\u00010G8\u0006¢\u0006\u000e\n\u0005\b»\u0001\u0010q\u001a\u0005\b¼\u0001\u0010rR&\u0010½\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010{\u001a\u0005\b½\u0001\u0010}\"\u0005\b¾\u0001\u0010\u007fR)\u0010¿\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010\u009b\u0001\u001a\u0006\b¿\u0001\u0010\u009d\u0001\"\u0006\bÀ\u0001\u0010\u009f\u0001R)\u0010Á\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010\u009b\u0001\u001a\u0006\bÁ\u0001\u0010\u009d\u0001\"\u0006\bÂ\u0001\u0010\u009f\u0001R)\u0010Ã\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010\u009b\u0001\u001a\u0006\bÃ\u0001\u0010\u009d\u0001\"\u0006\bÄ\u0001\u0010\u009f\u0001R)\u0010Å\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u009b\u0001\u001a\u0006\bÅ\u0001\u0010\u009d\u0001\"\u0006\bÆ\u0001\u0010\u009f\u0001R,\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R)\u0010Î\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R,\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R)\u0010Û\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010\u009b\u0001\u001a\u0006\bÜ\u0001\u0010\u009d\u0001\"\u0006\bÝ\u0001\u0010\u009f\u0001R\u001d\u0010ß\u0001\u001a\u00030Þ\u00018\u0006¢\u0006\u0010\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001R+\u0010ã\u0001\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010¡\u0001\u001a\u0006\bä\u0001\u0010£\u0001\"\u0006\bå\u0001\u0010¥\u0001R\u0018\u0010æ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bæ\u0001\u0010{R\u0019\u0010ç\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010\u009b\u0001R,\u0010è\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bè\u0001\u0010q\u001a\u0005\bé\u0001\u0010r\"\u0005\bê\u0001\u0010sR,\u0010ë\u0001\u001a\b\u0012\u0004\u0012\u00020\n0G8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bë\u0001\u0010q\u001a\u0005\bì\u0001\u0010r\"\u0005\bí\u0001\u0010sR\u0019\u0010î\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010\u009b\u0001R,\u0010ï\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010l\u001a\u0005\bð\u0001\u0010n\"\u0005\bñ\u0001\u0010pR&\u0010ò\u0001\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bò\u0001\u0010{\u001a\u0005\bó\u0001\u0010}\"\u0005\bô\u0001\u0010\u007fR;\u0010÷\u0001\u001a\u0014\u0012\u0004\u0012\u00020\n0õ\u0001j\t\u0012\u0004\u0012\u00020\n`ö\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001R!\u0010\u0082\u0002\u001a\u00030ý\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R(\u0010\u0083\u0002\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0083\u0002\u0010u\u001a\u0005\b\u0084\u0002\u0010w\"\u0005\b\u0085\u0002\u0010yR,\u0010\u0086\u0002\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0002\u0010l\u001a\u0005\b\u0087\u0002\u0010n\"\u0005\b\u0088\u0002\u0010pR,\u0010\u0089\u0002\u001a\b\u0012\u0004\u0012\u00020\n0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0002\u0010l\u001a\u0005\b\u008a\u0002\u0010n\"\u0005\b\u008b\u0002\u0010pR,\u0010\u008c\u0002\u001a\b\u0012\u0004\u0012\u00020\n0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0002\u0010l\u001a\u0005\b\u008d\u0002\u0010n\"\u0005\b\u008e\u0002\u0010pR,\u0010\u008f\u0002\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0002\u0010l\u001a\u0005\b\u0090\u0002\u0010n\"\u0005\b\u0091\u0002\u0010pR,\u0010\u0092\u0002\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0002\u0010l\u001a\u0005\b\u0093\u0002\u0010n\"\u0005\b\u0094\u0002\u0010pR,\u0010\u0095\u0002\u001a\b\u0012\u0004\u0012\u00020%0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0002\u0010l\u001a\u0005\b\u0096\u0002\u0010n\"\u0005\b\u0097\u0002\u0010pR#\u0010\u0099\u0002\u001a\t\u0012\u0004\u0012\u00020\n0\u0098\u00028\u0006¢\u0006\u0010\n\u0006\b\u0099\u0002\u0010\u009a\u0002\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002R+\u0010\u009d\u0002\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009d\u0002\u0010¡\u0001\u001a\u0006\b\u009e\u0002\u0010£\u0001\"\u0006\b\u009f\u0002\u0010¥\u0001R\u001c\u0010¡\u0002\u001a\u0005\u0018\u00010 \u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R,\u0010£\u0002\u001a\b\u0012\u0004\u0012\u00020\n0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0002\u0010l\u001a\u0005\b¤\u0002\u0010n\"\u0005\b¥\u0002\u0010pR+\u0010¦\u0002\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0002\u0010¡\u0001\u001a\u0006\b§\u0002\u0010£\u0001\"\u0006\b¨\u0002\u0010¥\u0001R+\u0010©\u0002\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0002\u0010¡\u0001\u001a\u0006\bª\u0002\u0010£\u0001\"\u0006\b«\u0002\u0010¥\u0001R!\u0010°\u0002\u001a\u00030¬\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u00ad\u0002\u0010ÿ\u0001\u001a\u0006\b®\u0002\u0010¯\u0002R\u0014\u0010±\u0002\u001a\u00020\u00068F¢\u0006\b\u001a\u0006\b±\u0002\u0010\u009d\u0001R\u0014\u0010³\u0002\u001a\u00020\n8F¢\u0006\b\u001a\u0006\b²\u0002\u0010£\u0001R\u0014\u0010µ\u0002\u001a\u00020*8F¢\u0006\b\u001a\u0006\b´\u0002\u0010Ñ\u0001¨\u0006º\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedState;", "Lcom/bytedance/android/ec/core/async/b;", "Ltd3/a;", "priceModel", "", "deleteGoodPriceItem", "", "addSearchCard", "", "scene", "checkAndGetGoodPriceCardReqScene", "Lcom/bytedance/android/shopping/feed/model/InflowGuessFeedResponse;", "inflowGuessFeedResponse", "postGoodPriceArea", "", "Lud3/d;", "baseProducts", "Lio/reactivex/Observable;", "tryGetGoodPriceProdObservable", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "promotions", "updatePromotion", "exchangeCouponSuccessUpdatePromotion", "preRecommend", "loadResourceCard", "productId", "", "getSearchCardPos", "getGuessULikeRank", "tryGetSearchCardObservable", "checkCanLoadSearchCard", "tryLoadSearchCard", "pos", "isShowSearchCard", "", "Lrd3/a;", "guessULikeList", "Lcom/bytedance/android/shopping/feed/model/SaveMoneyCardMarketingInfoResponse;", "response", "Lkotlin/Pair;", "", "updateMarketingBannerAndTipForGuessULike", "productStruct", "updateMarketingBannerAndTip", "isRecommendUpdate", "filters", "loadGuessULikeInternal", "guessLikeDataList", "tryReqGoodPrice", "anchorInflowFeedItemList", "getReqBaseProduct", "checkIsReqAllGuessGoodPriceStrip", "checkIsReqAllGuessGoodPriceCard", "isFirstLoadingGuessULike", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "requestParam", "isAdRequest", "pitayaGoodPriceEvent", "Ltd3/c;", "prodDetailBackModel", "pitayaProdDetailBackEvent", "Ltd3/b;", "inflowAutoExpandModel", "pitayaInflowAutoExpandEvent", "Lcom/bytedance/android/shopping/anchorv3/AnchorV3Param;", "anchorV3Param", "setAnchorV3Param", "tryLoadGoodPriceCardOrStrip", "getAnchorV3Param", "Landroidx/lifecycle/MutableLiveData;", "getAnchorV3ParamLiveData", "isForceRefreshHeadCard", "syncDynamic", "resp", "handleResourceCardResp", "anchorInflowFeedItem", "tryLoadGuessSearchCardV2", "guessULikeRank", "handleSearchCardResource", "loadMemberMarketingInfo", "isRecommendUpdateRequest", "loadGuessULike", "message", "handleGuessULikeRespError", "handleGuessULikeResp", "getCartNum", "visible", "updateFloatMallVisibility", "setGuessULikeDataList", "defaultState", "onCleared", "filePath", "imageUrl", "buildPhotoSearchSchema", "adapterPosition", "getSearchCardNumBefore", "goodPriceAreaNumBefore", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "headerList", "Ljava/util/List;", "getHeaderList", "()Ljava/util/List;", "setHeaderList", "(Ljava/util/List;)V", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "(Landroidx/lifecycle/MutableLiveData;)V", "headAnchorInflowFeedItem", "Lrd3/a;", "getHeadAnchorInflowFeedItem", "()Lrd3/a;", "setHeadAnchorInflowFeedItem", "(Lrd3/a;)V", "headImagePos", "I", "getHeadImagePos", "()I", "setHeadImagePos", "(I)V", "firstLoadGuessULikeResourceCardList", "getFirstLoadGuessULikeResourceCardList", "setFirstLoadGuessULikeResourceCardList", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;", "originalLiveEntry", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLiveEntryStruct;", "Landroidx/fragment/app/Fragment;", "flowFragment", "Landroidx/fragment/app/Fragment;", "getFlowFragment", "()Landroidx/fragment/app/Fragment;", "setFlowFragment", "(Landroidx/fragment/app/Fragment;)V", "Lnf/a;", "searchPanel", "Lnf/a;", "getSearchPanel", "()Lnf/a;", "setSearchPanel", "(Lnf/a;)V", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "hasBindProductFeedGuessULike", "Z", "getHasBindProductFeedGuessULike", "()Z", "setHasBindProductFeedGuessULike", "(Z)V", "productFeedGuessULikeMonitorName", "Ljava/lang/String;", "getProductFeedGuessULikeMonitorName", "()Ljava/lang/String;", "setProductFeedGuessULikeMonitorName", "(Ljava/lang/String;)V", "page", "Lcom/bytedance/android/shopping/feed/d;", "preloadDataCenter", "Lcom/bytedance/android/shopping/feed/d;", "getPreloadDataCenter", "()Lcom/bytedance/android/shopping/feed/d;", "setPreloadDataCenter", "(Lcom/bytedance/android/shopping/feed/d;)V", "isExpandedLiveData", "setExpandedLiveData", "isAutoExpandedLiveData", "setAutoExpandedLiveData", "firstLoadingGuessULikeLiveData", "getFirstLoadingGuessULikeLiveData", "setFirstLoadingGuessULikeLiveData", "popupViewLiveData", "getPopupViewLiveData", "Lsd3/a;", "gestureGuideLiveData", "getGestureGuideLiveData", "Lrd3/b;", "appointLiveData", "getAppointLiveData", "isAutoExpand", "setAutoExpand", "isHasExpandInflow", "setHasExpandInflow", "isInflowResume", "setInflowResume", "isOperate", "setOperate", "isSlideHeadImage", "setSlideHeadImage", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "innerFlowPageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "getInnerFlowPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "setInnerFlowPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;)V", "resumeTime", "J", "getResumeTime", "()J", "setResumeTime", "(J)V", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuPanelState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuPanelState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "setSkuPanelState", "(Lcom/bytedance/android/ec/model/sku/SkuRestoreState;)V", "hasEnterVideoDetailActivity", "getHasEnterVideoDetailActivity", "setHasEnterVideoDetailActivity", "Lcom/bytedance/android/shopping/feed/utils/m;", "innerGuessULikeFiltersHelper", "Lcom/bytedance/android/shopping/feed/utils/m;", "getInnerGuessULikeFiltersHelper", "()Lcom/bytedance/android/shopping/feed/utils/m;", "ecomSceneId", "getEcomSceneId", "setEcomSceneId", "guessULikeCursor", "isLoadingGuessULike", "showProductFeedDragGestureLiveData", "getShowProductFeedDragGestureLiveData", "setShowProductFeedDragGestureLiveData", "toastLiveData", "getToastLiveData", "setToastLiveData", "hasToastCoupon", "resourceCards", "getResourceCards", "setResourceCards", "topicCardShowPosition", "getTopicCardShowPosition", "setTopicCardShowPosition", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "showedSimilarEntranceProductId", "Ljava/util/HashSet;", "getShowedSimilarEntranceProductId", "()Ljava/util/HashSet;", "setShowedSimilarEntranceProductId", "(Ljava/util/HashSet;)V", "Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext$delegate", "Lkotlin/Lazy;", "getImageCallerContext", "()Lcom/bytedance/android/ec/core/imagex/r;", "imageCallerContext", "searchCard", "getSearchCard", "setSearchCard", "searchCardList", "getSearchCardList", "setSearchCardList", "searchFilterQueryIds", "getSearchFilterQueryIds", "setSearchFilterQueryIds", "searchFilterPIds", "getSearchFilterPIds", "setSearchFilterPIds", "goodPriceCards", "getGoodPriceCards", "setGoodPriceCards", "goodPriceCardList", "getGoodPriceCardList", "setGoodPriceCardList", "goodPriceStrips", "getGoodPriceStrips", "setGoodPriceStrips", "", "markProductIdToProdDetail", "Ljava/util/Set;", "getMarkProductIdToProdDetail", "()Ljava/util/Set;", "currentProductId", "getCurrentProductId", "setCurrentProductId", "Ljava/lang/Runnable;", "searchCardRunnable", "Ljava/lang/Runnable;", "hasShowGuessCardPid", "getHasShowGuessCardPid", "setHasShowGuessCardPid", "couponPageSchema", "getCouponPageSchema", "setCouponPageSchema", "halfScreenCouponPageSchema", "getHalfScreenCouponPageSchema", "setHalfScreenCouponPageSchema", "com/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel$exchangeCouponJsEvent$2$a", "exchangeCouponJsEvent$delegate", "getExchangeCouponJsEvent", "()Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel$exchangeCouponJsEvent$2$a;", "exchangeCouponJsEvent", "isExpanded", "getPageType", "pageType", "getDurationFromResume", "durationFromResume", "<init>", "()V", "Companion", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedViewModel extends JediViewModel<ProductFeedState> implements com.bytedance.android.ec.core.async.b {
    public static final b Companion = null;
    private static final String ECOM_COUPON_EXCHANGE_SUCCESS = "ecom_coupon_exchange_success";
    private final /* synthetic */ DisposableScope $$delegate_0;
    private MutableLiveData<AnchorV3Param> anchorV3Param;
    private final MutableLiveData<rd3.b> appointLiveData;
    private String couponPageSchema;
    private String currentProductId;
    private String ecomSceneId;
    private final Lazy exchangeCouponJsEvent$delegate;
    private List<? extends Object> firstLoadGuessULikeResourceCardList;
    private MutableLiveData<Boolean> firstLoadingGuessULikeLiveData;
    private Fragment flowFragment;
    private final MutableLiveData<sd3.a> gestureGuideLiveData;
    private List<rd3.a> goodPriceCardList;
    private List<rd3.a> goodPriceCards;
    private List<rd3.a> goodPriceStrips;
    private int guessULikeCursor;
    private String halfScreenCouponPageSchema;
    private boolean hasBindProductFeedGuessULike;
    private boolean hasEnterVideoDetailActivity;
    private List<String> hasShowGuessCardPid;
    private boolean hasToastCoupon;
    private rd3.a headAnchorInflowFeedItem;
    private int headImagePos;
    private List<? extends Object> headerList;
    private final Lazy imageCallerContext$delegate;
    private InnerFlowPageStyleDTO innerFlowPageStyle;
    private final com.bytedance.android.shopping.feed.utils.m innerGuessULikeFiltersHelper;
    private int isAutoExpand;
    private MutableLiveData<Boolean> isAutoExpandedLiveData;
    private MutableLiveData<Boolean> isExpandedLiveData;
    private boolean isHasExpandInflow;
    private boolean isInflowResume;
    private boolean isLoadingGuessULike;
    private boolean isOperate;
    private boolean isSlideHeadImage;
    private final Set<String> markProductIdToProdDetail;
    private PromotionProductLiveEntryStruct originalLiveEntry;
    private int page;
    private final MutableLiveData<Boolean> popupViewLiveData;
    private com.bytedance.android.shopping.feed.d preloadDataCenter;
    private String productFeedGuessULikeMonitorName;
    private PromotionProductStruct promotion;
    private List<rd3.a> resourceCards;
    private long resumeTime;
    private rd3.a searchCard;
    private List<rd3.a> searchCardList;
    private Runnable searchCardRunnable;
    private List<String> searchFilterPIds;
    private List<String> searchFilterQueryIds;
    private nf.a searchPanel;
    private MutableLiveData<Boolean> showProductFeedDragGestureLiveData;
    private HashSet<String> showedSimilarEntranceProductId;
    private SkuRestoreState skuPanelState;
    private MutableLiveData<String> toastLiveData;
    private int topicCardShowPosition;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a() {
            if (ECProdInnerPitayaMachine.b == true) goto L8;
            String r0 = ECAppInfoService.e.getAppId();
            if (r0 == null) goto L8;
            PitayaCoreFactory.getCore(r0).registerMessageHandler("ecom_video_display_low_price_module", new ECProdInnerPitayaMachine$registerGoodPriceMessageHandler$1$1());
            ECProdInnerPitayaMachine.b = true;
        L8:
            if (ECProdInnerPitayaMachine.c == true) goto L13;
            String r1 = ECAppInfoService.e.getAppId();
            if (r1 == null) goto L13;
            PitayaCoreFactory.getCore(r1).registerMessageHandler("ecom_video_product_detail_back", new ECProdInnerPitayaMachine$registerProductDetailBackMessageHandler$1$1());
            ECProdInnerPitayaMachine.c = true;
        L13:
            if (ECProdInnerPitayaMachine.d == true) goto L18;
            String r2 = ECAppInfoService.e.getAppId();
            if (r2 == null) goto L19;
            PitayaCoreFactory.getCore(r2).registerMessageHandler("ecom_expand_video_inflow_page", new ECProdInnerPitayaMachine$registerInflowAutoExpand$1$1());
            ECProdInnerPitayaMachine.d = true;
            return;
        L19:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements Observer<CartNumResponse> {
        public c() {
        }

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onNext(Object r4) {
            CartNumResponse r5 = (CartNumResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "resp");
            if (r5.getStatusCode() != 0) goto L12;
            EventBus r0 = EventBus.getDefault();
            CartNumData r6 = r5.getData();
            if (r6 == null) goto L9;
            Integer r7 = r6.getCount();
            if (r7 == null) goto L9;
            int r8 = r7.intValue();
        L10:
            r0.post(new hl.g(r8, false));
            return;
        L9:
            r8 = 0;
            goto L10
        }
    }

    public static final class d implements Observer<SaveMoneyCardMarketingInfoResponse> {
        public final /* synthetic */ ProductFeedViewModel a;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        public d(ProductFeedViewModel r1) {
            this.a = r1;
        }

        public final void onNext(Object r4) {
            final SaveMoneyCardMarketingInfoResponse r5 = (SaveMoneyCardMarketingInfoResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "t");
            dm.a.a("marketing_card").i("load on next");
            final LinkedHashSet r0 = new LinkedHashSet();
            ProductFeedViewModel.access$withState(this.a, new ProductFeedViewModel$loadMemberMarketingInfo$1$onNext$1(this, r5, r0));
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            com.bytedance.android.ec.core.async.a.a(r2, this.a);
        }
    }

    public static final class e implements Observer<InflowGuessFeedResponse> {
        public final /* synthetic */ ProductFeedViewModel a;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "disposable");
        }

        public e(ProductFeedViewModel r1) {
            this.a = r1;
        }

        public final void onNext(Object r2) {
            InflowGuessFeedResponse r3 = (InflowGuessFeedResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "resp");
            this.a.handleResourceCardResp(r3);
        }
    }

    public static final class f implements Observer<PromotionPackResponse> {
        public final /* synthetic */ ProductFeedViewModel a;
        public final /* synthetic */ boolean b;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            ECExceptionMonitor.e(r2);
        }

        public final void onNext(Object r4) {
            PromotionPackResponse r5 = (PromotionPackResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "resp");
            List r0 = r5.getPromotions();
            if (r0 == null) goto L22;
            AnchorV3Param r1 = (AnchorV3Param) this.a.getAnchorV3Param().getValue();
            if (r1 == null) goto L8;
            r1.setPromotions(r0);
        L8:
            AnchorV3Param r2 = (AnchorV3Param) this.a.getAnchorV3Param().getValue();
            if (r2 == null) goto L15;
            int r3 = com.bytedance.android.shopping.feed.viewmodel.a.a;
            InflowRespExtra r6 = r5.getExtra();
            if (r6 == null) goto L13;
            String r7 = r6.getAdExtra();
        L14:
            r2.setAdInnerFlowLogExtra(com.bytedance.android.shopping.feed.viewmodel.a.a(r7));
            goto L15
        L13:
            r7 = null;
        L15:
            Iterator r8 = r0.iterator();
        L17:
            if (r8.hasNext() == false) goto L19;
            ((PromotionProductStruct) r8.next()).setForceRefreshHeadCard(this.b);
            goto L17
        L19:
            ProductFeedViewModel.access$updatePromotion(this.a, r0);
            EventBus.getDefault().post(new hl.d(((PromotionProductStruct) ListProtector.get(r0, 0)).getCartProductCount()));
            return;
        }

        public f(ProductFeedViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ProductFeedViewModel a;
        public final /* synthetic */ String b;

        public g(ProductFeedViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ProductFeedViewModel r0 = this.a;
            ProductFeedViewModel.access$postGoodPriceArea(r0, (InflowGuessFeedResponse) r3, this.b);
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public static final class i<T, R> implements Function {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "it");
            return null;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ ProductFeedViewModel a;
        public final /* synthetic */ String b;

        public j(ProductFeedViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ProductFeedViewModel r0 = this.a;
            ProductFeedViewModel.access$postGoodPriceArea(r0, (InflowGuessFeedResponse) r3, this.b);
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public static final class l<T1, T2, R> implements BiFunction {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final Object apply(Object r3, Object r4) {
            InflowGuessFeedResponse r5 = (InflowGuessFeedResponse) r3;
            InflowGuessFeedResponse r6 = (InflowGuessFeedResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "t1");
            Intrinsics.checkNotNullParameter(r6, "t2");
            return CollectionsKt.mutableListOf(new InflowGuessFeedResponse[]{r5, r6});
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ ProductFeedViewModel a;
        public final /* synthetic */ PromotionProductBaseStruct b;
        public final /* synthetic */ String c;

        public m(ProductFeedViewModel r1, PromotionProductBaseStruct r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            List r7 = (List) r6;
            InflowGuessFeedResponse r0 = (InflowGuessFeedResponse) CollectionsKt.getOrNull(r7, 0);
            InflowGuessFeedResponse r8 = (InflowGuessFeedResponse) CollectionsKt.getOrNull(r7, 1);
            String r2 = this.b.getProductId();
            if (r0 == null) goto L6;
            if (r2 == null) goto L6;
            ProductFeedViewModel.access$setSearchCardRunnable$p(this.a, new com.bytedance.android.shopping.feed.viewmodel.c(r0, r2, this));
        L6:
            if (r8 != null) goto L8;
        L15:
            Runnable r9 = ProductFeedViewModel.access$getSearchCardRunnable$p(this.a);
            if (r9 == null) goto L18;
            r9.run();
        L18:
            ProductFeedViewModel.access$setSearchCardRunnable$p(this.a, null);
            return;
        L8:
            if ((!r8.getFeedItemAnchors().isEmpty()) == false) goto L15;
            Set<String> r1 = this.a.getMarkProductIdToProdDetail();
            String r3 = this.b.getProductId();
            if (r3 != null) goto L13;
            r3 = "";
        L13:
            if (r1.contains(r3) == true) goto L15;
            ProductFeedViewModel.access$postGoodPriceArea(this.a, r8, this.c);
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public static final class o<T, R> implements Function {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "it");
            return null;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ ProductFeedViewModel a;
        public final /* synthetic */ String b;

        public p(ProductFeedViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ProductFeedViewModel r0 = this.a;
            int r1 = ProductFeedViewModel.access$getSearchCardPos(r0, this.b);
            String r2 = this.b;
            r0.handleSearchCardResource((InflowGuessFeedResponse) r5, r1, r2, ProductFeedViewModel.access$getGuessULikeRank(this.a, r2));
        }
    }

    public static final class q<T> implements Consumer {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    static {
        Companion = new b();
    }

    private final ProductFeedViewModel$exchangeCouponJsEvent$2.a getExchangeCouponJsEvent() {
        return (ProductFeedViewModel$exchangeCouponJsEvent$2.a) this.exchangeCouponJsEvent$delegate.getValue();
    }

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.add(r2);
        return r2;
    }

    public void clearDisposable() {
        this.$$delegate_0.clearDisposable();
    }

    public final r getImageCallerContext() {
        return (r) this.imageCallerContext$delegate.getValue();
    }

    public final nf.a getSearchPanel() {
        return null;
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.$$delegate_0.remove(r2);
    }

    public final void setSearchPanel(nf.a r1) {
    }

    private final boolean checkIsReqAllGuessGoodPriceCard() {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L22;
        AnchorV3PromotionRequestParam r1 = r0.getRequestParam();
        if (r1 == null) goto L23;
        List r2 = r1.getGoodPriceParam();
        if (r2 == null) goto L26;
        AnchorV3Param r3 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r3 == null) goto L16;
        AnchorV3PromotionRequestParam r4 = r3.getRequestParam();
        if (r4 == null) goto L16;
        Integer r5 = r4.getGoodPriceCardGuessLikeOpt();
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
    L18:
        if (r2.contains(GoodPriceCardOrStripType.GOOD_PRICE_CARD_2.getType()) == false) goto L24;
        if (r6 == 0) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        r6 = 0;
        goto L18
    L26:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    private final boolean checkIsReqAllGuessGoodPriceStrip() {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L11;
        AnchorV3PromotionRequestParam r1 = r0.getRequestParam();
        if (r1 == null) goto L13;
        List r2 = r1.getGoodPriceParam();
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.contains(GoodPriceCardOrStripType.FAVOURITE_BAR.getType());
    L13:
        return false;
    L11:
        return false;
    }

    private final void exchangeCouponSuccessUpdatePromotion() {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L25;
        final List r1 = r0.getPromotions();
        if (r1 == null) goto L26;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        PromotionProductStruct r3 = (PromotionProductStruct) r2.next();
        PromotionProductPrivilegesStruct r4 = r3.getPrivilegeInfo();
        if (r4 == null) goto L15;
        PromotionProductCouponsStruct r5 = r4.getCoupons();
        if (r5 == null) goto L15;
        r5.setExchangeCoupons(null);
    L15:
        r3.setForceRefreshExchangeCouponTips(true);
        goto L9
    L16:
        AnchorV3Param r6 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r6 == null) goto L19;
        r6.setPromotions(r1);
    L19:
        ArrayList r7 = new ArrayList();
        r7.addAll(r1);
        Unit r8 = Unit.INSTANCE;
        this.headerList = r7;
        setState(new AnonymousClass3(this, r1));
        return;
    L26:
        return;
    }

    private final boolean isFirstLoadingGuessULike() {
        if (this.page == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public CompositeDisposable compositeDisposable() {
        return this.$$delegate_0.a();
    }

    public ProductFeedState defaultState() {
        return new ProductFeedState(0);
    }

    /* JADX INFO: renamed from: getAnchorV3Param, reason: collision with other method in class */
    public final AnchorV3Param m907getAnchorV3Param() {
        return (AnchorV3Param) this.anchorV3Param.getValue();
    }

    public final void getCartNum() {
        InnerGuessULikeApi.a.getClass();
        InnerGuessULikeApi r0 = InnerGuessULikeApi.a.a;
        if (r0 == null) goto L12;
        Observable<CartNumResponse> r1 = r0.getCartNum();
        if (r1 == null) goto L13;
        Observable r2 = r1.subscribeOn(Schedulers.io());
        if (r2 == null) goto L14;
        Observable r3 = r2.observeOn(AndroidSchedulers.mainThread());
        if (r3 == null) goto L15;
        r3.subscribe(new c());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final boolean isExpanded() {
        return Intrinsics.areEqual((Boolean) this.isExpandedLiveData.getValue(), Boolean.TRUE);
    }

    public final void loadMemberMarketingInfo() {
        dm.a.a("marketing_card").i("loadMemberMarketingInfo");
        InnerAdditionalApi.a.getClass();
        InnerAdditionalApi r0 = InnerAdditionalApi.a.a;
        if (r0 == null) goto L12;
        Observable<SaveMoneyCardMarketingInfoResponse> r1 = r0.fetchMarketingMember();
        if (r1 == null) goto L13;
        Observable r2 = r1.subscribeOn(Schedulers.io());
        if (r2 == null) goto L14;
        Observable r3 = r2.observeOn(AndroidSchedulers.mainThread());
        if (r3 == null) goto L15;
        r3.subscribe(new d(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public ProductFeedViewModel() {
        this.$$delegate_0 = new DisposableScope();
        this.headerList = CollectionsKt.emptyList();
        this.anchorV3Param = new MutableLiveData();
        this.firstLoadGuessULikeResourceCardList = CollectionsKt.emptyList();
        this.productFeedGuessULikeMonitorName = "";
        this.page = 1;
        this.isExpandedLiveData = new MutableLiveData();
        this.isAutoExpandedLiveData = new MutableLiveData();
        this.firstLoadingGuessULikeLiveData = new MutableLiveData();
        this.popupViewLiveData = new MutableLiveData();
        this.gestureGuideLiveData = new MutableLiveData();
        this.appointLiveData = new MutableLiveData();
        this.isInflowResume = true;
        this.resumeTime = SystemClock.uptimeMillis();
        this.innerGuessULikeFiltersHelper = new com.bytedance.android.shopping.feed.utils.m();
        this.showProductFeedDragGestureLiveData = new MutableLiveData();
        this.toastLiveData = new MutableLiveData();
        this.resourceCards = new ArrayList();
        this.topicCardShowPosition = -1;
        this.showedSimilarEntranceProductId = new HashSet();
        this.imageCallerContext$delegate = LazyKt.lazy(ProductFeedViewModel$imageCallerContext$2.INSTANCE);
        this.searchCardList = new ArrayList();
        this.searchFilterQueryIds = new ArrayList();
        this.searchFilterPIds = new ArrayList();
        this.goodPriceCards = new ArrayList();
        this.goodPriceCardList = new ArrayList();
        this.goodPriceStrips = new ArrayList();
        this.markProductIdToProdDetail = new LinkedHashSet();
        this.hasShowGuessCardPid = new ArrayList();
        this.exchangeCouponJsEvent$delegate = LazyKt.lazy(new ProductFeedViewModel$exchangeCouponJsEvent$2(this));
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L5;
        ECLiveHybridUtil.m(ECOM_COUPON_EXCHANGE_SUCCESS, getExchangeCouponJsEvent());
    L5:
        ((ExecutorService) ECProdInnerPitayaMachine.a.getValue()).submit(a.a);
        s0.c(this);
    }

    public final long getDurationFromResume() {
        return System.currentTimeMillis() - this.resumeTime;
    }

    public final String getPageType() {
        if (isExpanded() == false) goto L5;
        return "full_screen";
    L5:
        return "half_screen";
    }

    public void onCleared() {
        super.onCleared();
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L5;
        ECLiveHybridUtil.p(ECOM_COUPON_EXCHANGE_SUCCESS, getExchangeCouponJsEvent());
    L5:
        clearDisposable();
        s0.e(this);
        this.searchCardRunnable = null;
    }

    public final MutableLiveData<AnchorV3Param> getAnchorV3ParamLiveData() {
        return this.anchorV3Param;
    }

    public final MutableLiveData<rd3.b> getAppointLiveData() {
        return this.appointLiveData;
    }

    public final String getCouponPageSchema() {
        return this.couponPageSchema;
    }

    public final String getCurrentProductId() {
        return this.currentProductId;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final List<Object> getFirstLoadGuessULikeResourceCardList() {
        return this.firstLoadGuessULikeResourceCardList;
    }

    public final MutableLiveData<Boolean> getFirstLoadingGuessULikeLiveData() {
        return this.firstLoadingGuessULikeLiveData;
    }

    public final Fragment getFlowFragment() {
        return this.flowFragment;
    }

    public final MutableLiveData<sd3.a> getGestureGuideLiveData() {
        return this.gestureGuideLiveData;
    }

    public final List<rd3.a> getGoodPriceCardList() {
        return this.goodPriceCardList;
    }

    public final List<rd3.a> getGoodPriceCards() {
        return this.goodPriceCards;
    }

    public final List<rd3.a> getGoodPriceStrips() {
        return this.goodPriceStrips;
    }

    public final String getHalfScreenCouponPageSchema() {
        return this.halfScreenCouponPageSchema;
    }

    public final boolean getHasBindProductFeedGuessULike() {
        return this.hasBindProductFeedGuessULike;
    }

    public final boolean getHasEnterVideoDetailActivity() {
        return this.hasEnterVideoDetailActivity;
    }

    public final List<String> getHasShowGuessCardPid() {
        return this.hasShowGuessCardPid;
    }

    public final rd3.a getHeadAnchorInflowFeedItem() {
        return this.headAnchorInflowFeedItem;
    }

    public final int getHeadImagePos() {
        return this.headImagePos;
    }

    public final List<Object> getHeaderList() {
        return this.headerList;
    }

    public final InnerFlowPageStyleDTO getInnerFlowPageStyle() {
        return this.innerFlowPageStyle;
    }

    public final com.bytedance.android.shopping.feed.utils.m getInnerGuessULikeFiltersHelper() {
        return this.innerGuessULikeFiltersHelper;
    }

    public final Set<String> getMarkProductIdToProdDetail() {
        return this.markProductIdToProdDetail;
    }

    public final MutableLiveData<Boolean> getPopupViewLiveData() {
        return this.popupViewLiveData;
    }

    public final com.bytedance.android.shopping.feed.d getPreloadDataCenter() {
        return this.preloadDataCenter;
    }

    public final String getProductFeedGuessULikeMonitorName() {
        return this.productFeedGuessULikeMonitorName;
    }

    public final PromotionProductStruct getPromotion() {
        return this.promotion;
    }

    public final List<rd3.a> getResourceCards() {
        return this.resourceCards;
    }

    public final long getResumeTime() {
        return this.resumeTime;
    }

    public final rd3.a getSearchCard() {
        return this.searchCard;
    }

    public final List<rd3.a> getSearchCardList() {
        return this.searchCardList;
    }

    public final List<String> getSearchFilterPIds() {
        return this.searchFilterPIds;
    }

    public final List<String> getSearchFilterQueryIds() {
        return this.searchFilterQueryIds;
    }

    public final MutableLiveData<Boolean> getShowProductFeedDragGestureLiveData() {
        return this.showProductFeedDragGestureLiveData;
    }

    public final HashSet<String> getShowedSimilarEntranceProductId() {
        return this.showedSimilarEntranceProductId;
    }

    public final SkuRestoreState getSkuPanelState() {
        return this.skuPanelState;
    }

    public final MutableLiveData<String> getToastLiveData() {
        return this.toastLiveData;
    }

    public final int getTopicCardShowPosition() {
        return this.topicCardShowPosition;
    }

    public final int isAutoExpand() {
        return this.isAutoExpand;
    }

    public final MutableLiveData<Boolean> isAutoExpandedLiveData() {
        return this.isAutoExpandedLiveData;
    }

    public final MutableLiveData<Boolean> isExpandedLiveData() {
        return this.isExpandedLiveData;
    }

    public final boolean isHasExpandInflow() {
        return this.isHasExpandInflow;
    }

    public final boolean isInflowResume() {
        return this.isInflowResume;
    }

    public final boolean isOperate() {
        return this.isOperate;
    }

    public final boolean isSlideHeadImage() {
        return this.isSlideHeadImage;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m906defaultState() {
        return defaultState();
    }

    public final MutableLiveData<AnchorV3Param> getAnchorV3Param() {
        return this.anchorV3Param;
    }

    public static final /* synthetic */ void access$exchangeCouponSuccessUpdatePromotion(ProductFeedViewModel r0) {
        r0.exchangeCouponSuccessUpdatePromotion();
    }

    public static final /* synthetic */ int access$getGuessULikeCursor$p(ProductFeedViewModel r0) {
        return r0.guessULikeCursor;
    }

    public static final /* synthetic */ int access$getPage$p(ProductFeedViewModel r0) {
        return r0.page;
    }

    public static final /* synthetic */ Runnable access$getSearchCardRunnable$p(ProductFeedViewModel r0) {
        return r0.searchCardRunnable;
    }

    public static final /* synthetic */ boolean access$isFirstLoadingGuessULike(ProductFeedViewModel r0) {
        return r0.isFirstLoadingGuessULike();
    }

    private final void addSearchCard(td3.a r4) {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.getVideoId();
    L7:
        if (Intrinsics.areEqual(r1, r4.c()) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.currentProductId, r4.b()) == false) goto L16;
        Runnable r5 = this.searchCardRunnable;
        if (r5 == null) goto L13;
        r5.run();
    L13:
        this.searchCardRunnable = null;
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final boolean checkAndGetGoodPriceCardReqScene(String r2) {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L11;
        AnchorV3PromotionRequestParam r1 = r0.getRequestParam();
        if (r1 == null) goto L13;
        List r3 = r1.getGoodPriceParam();
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.contains(r2);
    L13:
        return false;
    L11:
        return false;
    }

    private final boolean checkCanLoadSearchCard(String r3) {
        InnerFlowPageStyleDTO r0 = this.innerFlowPageStyle;
        if (r0 == null) goto L8;
        PageStyle r1 = r0.getPageStyle();
        if (r1 == null) goto L8;
        if (r1.searchCardWithPicture() != true) goto L8;
    L15:
        if (isShowSearchCard(getSearchCardPos(r3)) == false) goto L23;
        AnchorV3Param r4 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r4 == null) goto L19;
        AnchorV3PromotionRequestParam r5 = r4.getRequestParam();
    L21:
        if (isAdRequest(r5) == true) goto L23;
        return true;
    L19:
        r5 = null;
    L23:
        return false;
    L8:
        InnerFlowPageStyleDTO r2 = this.innerFlowPageStyle;
        if (r2 == null) goto L23;
        PageStyle r6 = r2.getPageStyle();
        if (r6 == null) goto L23;
        if (r6.searchCardWithHashTag() != true) goto L23;
        goto L23
    }

    private final boolean deleteGoodPriceItem(td3.a r5) {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        final String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getVideoId();
    L6:
        boolean r3 = false;
        if (Intrinsics.areEqual(r2, r5.c()) == true) goto L9;
    L25:
        return false;
    L9:
        if (Intrinsics.areEqual(this.currentProductId, r5.b()) == false) goto L25;
        Set<String> r6 = this.markProductIdToProdDetail;
        String r4 = this.currentProductId;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r6.contains(r4) == true) goto L25;
        String r7 = this.currentProductId;
        if (r7 != null) goto L18;
    L24:
        return true;
    L18:
        if (r7.length() <= 0) goto L20;
        r3 = true;
    L20:
        if (r3 == false) goto L22;
        r1 = r7;
    L22:
        if (r1 == null) goto L24;
        this.markProductIdToProdDetail.add(r1);
        setState(new ProductFeedViewModel$deleteGoodPriceItem$2$1(r1));
        goto L24
    L5:
        r2 = null;
        goto L6
    }

    private final int getGuessULikeRank(String r5) {
        Fragment r0 = this.flowFragment;
        if ((r0 instanceof ProductFeedContentFragment) == true) goto L5;
        r0 = null;
    L5:
        ProductFeedContentFragment r1 = (ProductFeedContentFragment) r0;
        if (r1 == null) goto L10;
        com.bytedance.android.shopping.feed.viewmodel.b r2 = r1.t;
        if (r2 == null) goto L10;
        List<rd3.a> r3 = r2.d;
    L11:
        if (r3 == null) goto L29;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L28;
        rd3.a r6 = (rd3.a) r4.next();
        Promotion r7 = r6.f();
        if (r7 == null) goto L22;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L22;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L22;
        String r10 = r9.getProductId();
    L24:
        if (Intrinsics.areEqual(r10, r5) == false) goto L14;
        if (r6 == null) goto L29;
        return r6.f;
    L22:
        r10 = null;
        goto L24
    L28:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L29:
        return -1;
    L10:
        r3 = null;
        goto L11
    }

    private final List<ud3.d> getReqBaseProduct(List<rd3.a> r14) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L29;
        rd3.a r1 = (rd3.a) r15.next();
        int r2 = com.bytedance.android.shopping.feed.utils.c.a;
        Promotion r3 = r1.f();
        String r4 = null;
        if (r3 == null) goto L10;
        PromotionProductStruct r5 = r3.getPromotionInfo();
        if (r5 == null) goto L10;
        PromotionProductPriceStruct r6 = r5.getProductPrice();
    L11:
        Long r7 = com.bytedance.android.shopping.feed.utils.c.d(r6);
        if (r7 == null) goto L4;
        long r8 = r7.longValue();
        Promotion r9 = r1.f();
        if (r9 == null) goto L4;
        PromotionProductStruct r10 = r9.getPromotionInfo();
        if (r10 == null) goto L4;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L4;
        String r12 = r11.getProductId();
        String r13 = r11.getShopId();
        String r16 = r11.getSkuId();
        List r17 = r11.getImages();
        if (r17 == null) goto L24;
        ECUrlModel r18 = (ECUrlModel) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L24;
        String r19 = r18.getFirstUrl();
    L25:
        Long r110 = Long.valueOf(r8);
        AnchorV3Param r20 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r20 == null) goto L28;
        r4 = r20.getAuthorId();
    L28:
        r0.add(new ud3.d(r12, r13, r16, r19, r110, r4));
    L24:
        r19 = null;
    L10:
        r6 = null;
        goto L11
    L29:
        return r0;
    }

    private final int getSearchCardPos(String r6) {
        Fragment r0 = this.flowFragment;
        if ((r0 instanceof ProductFeedContentFragment) == true) goto L5;
        r0 = null;
    L5:
        ProductFeedContentFragment r1 = (ProductFeedContentFragment) r0;
        if (r1 == null) goto L10;
        com.bytedance.android.shopping.feed.viewmodel.b r2 = r1.t;
        if (r2 == null) goto L10;
        List<rd3.a> r3 = r2.d;
    L12:
        if (r3 == null) goto L28;
        Iterator<rd3.a> r4 = r3.iterator();
        int r5 = 0;
    L15:
        if (r4.hasNext() == false) goto L28;
        Promotion r7 = r4.next().f();
        if (r7 == null) goto L23;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L23;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L23;
        String r10 = r9.getProductId();
    L25:
        if (Intrinsics.areEqual(r10, r6) == true) goto L29;
        r5 = r5 + 1;
    L29:
        if (r5 >= 0) goto L31;
        return -1;
    L31:
        return r5 + 1;
    L23:
        r10 = null;
    L28:
        r5 = -1;
    L10:
        r3 = null;
        goto L12
    }

    private final boolean isAdRequest(AnchorV3PromotionRequestParam r3) {
        if (r3 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "$this$isAdRequest");
        if (r3.getAggParams() != null) goto L7;
        return false;
    L7:
        return true;
    L8:
        return false;
    }

    private final boolean isShowSearchCard(int r6) {
        rd3.a r0 = this.searchCard;
        if (r0 == null) goto L7;
        yd3.p r1 = r0.i();
        if (r1 == null) goto L7;
        int r2 = r1.m();
    L8:
        if (r6 < 0) goto L27;
        InnerFlowPageStyleDTO r3 = this.innerFlowPageStyle;
        int r4 = -1;
        if (r3 == null) goto L14;
        PageStyle r5 = r3.getPageStyle();
        if (r5 == null) goto L14;
        int r7 = r5.getSearchCardFreq();
    L16:
        if (r7 < 1) goto L27;
        if (r2 <= 0) goto L26;
        int r8 = r6 - r2;
        InnerFlowPageStyleDTO r9 = this.innerFlowPageStyle;
        if (r9 == null) goto L24;
        PageStyle r10 = r9.getPageStyle();
        if (r10 == null) goto L24;
        r4 = r10.getSearchCardFreq();
    L24:
        if (r8 > r4) goto L26;
        return false;
    L26:
        return true;
    L14:
        r7 = -1;
    L27:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    private final void loadResourceCard(String r17) {
        InnerGuessULikeApi.a.getClass();
        InnerGuessULikeApi r2 = InnerGuessULikeApi.a.a;
        if (r2 == null) goto L50;
        AnchorV3Param r1 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r1 == null) goto L8;
        String r3 = r1.getProductId();
        if (r3 == null) goto L8;
    L9:
        String r4 = com.bytedance.android.shopping.feed.utils.g.a();
        int r5 = com.bytedance.android.shopping.feed.utils.b.a;
        AnchorV3Param r6 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r6 == null) goto L14;
        AnchorV3PromotionRequestParam r7 = r6.getRequestParam();
        if (r7 == null) goto L14;
        String r8 = r7.getMetaParam();
    L15:
        String r9 = com.bytedance.android.shopping.feed.utils.b.d(r8);
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        AnchorV3Param r10 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r10 == null) goto L21;
        String r11 = r10.getAuthorId();
    L22:
        AnchorV3Param r12 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r12 == null) goto L25;
        String r13 = r12.getAuthorOpenId();
    L26:
        AnchorV3Param r14 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r14 == null) goto L31;
        ECAnchorV3ExtraData r15 = r14.getAnchorV3ExtraData();
        if (r15 == null) goto L31;
        String r16 = r15.getShopId();
    L32:
        AnchorV3Param r18 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r18 == null) goto L35;
        String r19 = r18.getVideoId();
    L36:
        AnchorV3Param r20 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r20 == null) goto L41;
        ECLogExtraData r21 = r20.getLogExtraData();
        if (r21 == null) goto L41;
        String r110 = r21.getEnterFrom();
    L42:
        Observable r22 = InnerGuessULikeApi.b.b(r2, r3, r4, r9, r11, r13, r16, r19, r17, r110, 0, null, null, 934366);
        if (r22 == null) goto L51;
        Observable r23 = r22.subscribeOn(Schedulers.io());
        if (r23 == null) goto L52;
        Observable r24 = r23.observeOn(AndroidSchedulers.mainThread());
        if (r24 == null) goto L53;
        r24.subscribe(new e(this));
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L41:
        r110 = null;
        goto L42
    L35:
        r19 = null;
    L31:
        r16 = null;
        goto L32
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
    L14:
        r8 = null;
    L8:
        r3 = "";
        goto L9
    }

    private final Observable<InflowGuessFeedResponse> tryGetSearchCardObservable(String r26) {
        if (checkCanLoadSearchCard(r26) == false) goto L47;
        InnerGuessULikeApi.a.getClass();
        InnerGuessULikeApi r3 = InnerGuessULikeApi.a.a;
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r26 != null) goto L9;
        String r4 = "";
    L10:
        String r5 = com.bytedance.android.shopping.feed.utils.g.a();
        int r6 = com.bytedance.android.shopping.feed.utils.b.a;
        AnchorV3Param r7 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r7 == null) goto L15;
        AnchorV3PromotionRequestParam r8 = r7.getRequestParam();
        if (r8 == null) goto L15;
        String r9 = r8.getMetaParam();
    L16:
        String r10 = com.bytedance.android.shopping.feed.utils.b.d(r9);
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        AnchorV3Param r1 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r1 == null) goto L22;
        String r11 = r1.getAuthorId();
    L23:
        AnchorV3Param r2 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r2 == null) goto L26;
        String r12 = r2.getAuthorOpenId();
    L27:
        AnchorV3Param r13 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r13 == null) goto L32;
        ECAnchorV3ExtraData r14 = r13.getAnchorV3ExtraData();
        if (r14 == null) goto L32;
        String r15 = r14.getShopId();
    L33:
        AnchorV3Param r16 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r16 == null) goto L36;
        String r17 = r16.getVideoId();
    L37:
        AnchorV3Param r18 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r18 == null) goto L42;
        ECLogExtraData r19 = r18.getLogExtraData();
        if (r19 == null) goto L42;
        String r110 = r19.getEnterFrom();
    L43:
        Observable r20 = InnerGuessULikeApi.b.b(r3, r4, r5, r10, r11, r12, r15, r17, null, r110, 1, CollectionsKt.joinToString$default(this.searchFilterQueryIds, ",", null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default(this.searchFilterPIds, ",", null, null, 0, null, null, 62, null) + CollectionsKt.joinToString$default(this.innerGuessULikeFiltersHelper.c, ",", null, null, 0, null, null, 62, null), 49630);
        if (r20 != null) goto L46;
        return null;
    L46:
        return r20.subscribeOn(Schedulers.io());
    L42:
        r110 = null;
        goto L43
    L36:
        r17 = null;
    L32:
        r15 = null;
        goto L33
    L26:
        r12 = null;
        goto L27
    L22:
        r11 = null;
    L15:
        r9 = null;
        goto L16
    L9:
        r4 = r26;
        goto L10
    L47:
        return null;
    }

    private final void tryLoadSearchCard(String r3) {
        Observable<InflowGuessFeedResponse> r0 = tryGetSearchCardObservable(r3);
        if (r0 == null) goto L8;
        Observable r1 = r0.observeOn(AndroidSchedulers.mainThread());
        if (r1 == null) goto L9;
        r1.subscribe(new p(this, r3), q.a);
        return;
    L9:
        return;
    }

    private final void updatePromotion(final List<? extends PromotionProductStruct> r6) {
        boolean r0 = false;
        this.promotion = (PromotionProductStruct) ListProtector.get(r6, 0);
        ArrayList r1 = new ArrayList();
        r1.addAll(r6);
        Unit r2 = Unit.INSTANCE;
        this.headerList = r1;
        PromotionProductStruct r3 = this.promotion;
        if (r3 != null) goto L5;
    L25:
        setState(new C02712(this, r6));
        return;
    L5:
        if (r3.isApiBack() != true) goto L25;
        if (this.hasToastCoupon == true) goto L25;
        this.hasToastCoupon = true;
        int r4 = ECSdk.a;
        IEShoppingService r5 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r5 == null) goto L16;
        PromotionProductStruct r7 = this.promotion;
        Fragment r8 = this.flowFragment;
        if (r8 == null) goto L13;
        Context r9 = r8.getContext();
    L14:
        String r10 = r5.toastIfAutoApplyCoupon(r7, r9);
        if (r10 == null) goto L16;
    L18:
        if (r10.length() <= 0) goto L20;
        r0 = true;
    L20:
        if (r0 == false) goto L22;
        this.toastLiveData.setValue(r10);
        goto L25
    L22:
        Boolean r11 = (Boolean) this.showProductFeedDragGestureLiveData.getValue();
        Boolean r12 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r11, r12)) == false) goto L25;
        this.showProductFeedDragGestureLiveData.setValue(r12);
        goto L25
    L13:
        r9 = null;
    L16:
        r10 = "";
        goto L18
    }

    public final int getSearchCardNumBefore(int r5) {
        Iterator<T> r0 = this.searchCardList.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((rd3.a) r0.next()).f >= r5) goto L4;
        r2 = r2 + 1;
        goto L4
    L8:
        if (r2 > 0) goto L10;
        return 0;
    L10:
        return r2;
    }

    public final int goodPriceAreaNumBefore(int r4) {
        Iterator<T> r0 = this.goodPriceCardList.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((rd3.a) r0.next()).f >= r4) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    public final void handleGuessULikeRespError(String r3) {
        FeedProductEventTracker.a.getClass();
        FeedProductEventTracker.C("load_product_feed_guessulike_api_fail", this, null, null, r3);
        setState(AnonymousClass1.INSTANCE);
        this.isLoadingGuessULike = false;
    }

    public final void handleResourceCardResp(InflowGuessFeedResponse r5) {
        Intrinsics.checkNotNullParameter(r5, "resp");
        Iterator<T> r0 = r5.getFeedItemAnchors().iterator();
    L3:
        Object r2 = null;
        String r3 = null;
        if (r0.hasNext() == false) goto L9;
        rd3.a r1 = (rd3.a) r0.next();
        rd3.f r4 = r5.getExtra();
        if (r4 == null) goto L8;
        r3 = r4.a();
    L8:
        r1.d = r3;
        r1.c = this;
        goto L3
    L9:
        this.resourceCards = r5.getFeedItemAnchors();
        Iterator<T> r6 = r5.getFeedItemAnchors().iterator();
    L11:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        yd3.p r8 = ((rd3.a) r7).i();
        if (r8 != null) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L11;
        r2 = r7;
        goto L20
    L15:
        if (r8.getType() != 5) goto L17;
        r9 = true;
    L20:
        rd3.a r10 = (rd3.a) r2;
        int r11 = -1;
        if (r10 == null) goto L25;
        yd3.p r12 = r10.i();
        if (r12 == null) goto L25;
        r11 = r12.m();
    L25:
        if (r11 <= 0) goto L27;
        r11 = r11 + 1;
    L27:
        this.topicCardShowPosition = r11;
        setState(new AnonymousClass4(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void pitayaGoodPriceEvent(td3.a r4) {
        Intrinsics.checkNotNullParameter(r4, "priceModel");
        dm.a.a("lgz_log_debug").a("pitayaGoodPriceEvent priceModel:" + r4);
        if (Intrinsics.areEqual(r4.a(), GoodPriceActionType.DELETE.getType()) == false) goto L32;
        String r0 = r4.b();
        boolean r1 = true;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L33;
        String r3 = r4.c();
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L34;
        String r6 = this.currentProductId;
        if (r6 != null) goto L23;
    L26:
        if (r1 == false) goto L29;
        return;
    L29:
        if (deleteGoodPriceItem(r4) == false) goto L35;
        addSearchCard(r4);
        return;
    L35:
        return;
    L23:
        if (r6.length() == 0) goto L26;
        r1 = false;
        goto L26
    L34:
        return;
    L15:
        if (r3.length() == 0) goto L18;
        r5 = false;
        goto L19
    L33:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void pitayaInflowAutoExpandEvent(td3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "inflowAutoExpandModel");
        dm.a.b r0 = dm.a.a("lgz_log_debug");
        StringBuilder r1 = new StringBuilder("pitayaInflowAutoExpandEvent inflowAutoExpandModel:");
        r1.append(r5);
        r1.append(" realVideoId:");
        AnchorV3Param r2 = (AnchorV3Param) this.anchorV3Param.getValue();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getVideoId();
    L6:
        r1.append(r4);
        r1.append(" realAuthorId:");
        AnchorV3Param r6 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r6 == null) goto L9;
        String r7 = r6.getAuthorId();
    L10:
        r1.append(r7);
        r0.a(r1.toString());
        String r8 = r5.b();
        boolean r9 = true;
        if (r8 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L60;
        String r11 = r5.a();
        if (r11 != null) goto L21;
    L24:
        if (r9 == true) goto L67;
        AnchorV3Param r12 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r12 == null) goto L29;
        String r13 = r12.getVideoId();
    L31:
        if (Intrinsics.areEqual(r13, r5.b()) == false) goto L61;
        AnchorV3Param r14 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r14 == null) goto L36;
        r3 = r14.getAuthorId();
    L36:
        if (Intrinsics.areEqual(r3, r5.a()) == true) goto L38;
        return;
    L38:
        if (this.isInflowResume == true) goto L40;
        return;
    L40:
        if (this.isHasExpandInflow == false) goto L42;
        return;
    L42:
        if (this.isOperate == false) goto L44;
        return;
    L44:
        if (this.isSlideHeadImage == true) goto L66;
        Integer r15 = r5.c();
        int r16 = TriggerModeType.NEW_USER.getType();
        if (r15 != null) goto L49;
    L51:
        int r17 = TriggerModeType.OTHER_USER.getType();
        if (r15 != null) goto L55;
    L57:
        AutoExpandType.DEFAULT.getType();
    L58:
        MutableLiveData<Boolean> r18 = this.isExpandedLiveData;
        Boolean r19 = Boolean.TRUE;
        r18.setValue(r19);
        this.isAutoExpandedLiveData.setValue(r19);
        return;
    L55:
        if (r15.intValue() != r17) goto L57;
        this.isAutoExpand = AutoExpandType.OTHER_USER_AUTO_EXPAND.getType();
        goto L58
    L49:
        if (r15.intValue() != r16) goto L51;
        this.isAutoExpand = AutoExpandType.NEW_USER_AUTO_EXPAND.getType();
        goto L58
    L66:
        return;
    L61:
        return;
    L29:
        r13 = null;
        goto L31
    L67:
        return;
    L21:
        if (r11.length() == 0) goto L24;
        r9 = false;
        goto L24
    L60:
        return;
    L13:
        if (r8.length() == 0) goto L16;
        r10 = false;
        goto L17
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void pitayaProdDetailBackEvent(td3.c r6) {
        Intrinsics.checkNotNullParameter(r6, "prodDetailBackModel");
        dm.a.a("lgz_log_debug").a("pitayaProdDetailBackEvent prodDetailBackModule:" + r6);
        Boolean r0 = r6.b();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L42;
        String r2 = r6.d();
        boolean r3 = true;
        if (r2 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L43;
        String r5 = r6.a();
        if (r5 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(r6.c(), JumpFromType.GUESS_U_LIKE.getType()) == true) goto L45;
        String r8 = this.currentProductId;
        if (r8 != null) goto L25;
    L28:
        if (r3 == true) goto L46;
        sk.a.a.getClass();
        if (com.bytedance.android.ec.sdk.helper.q.a.getInt("ec_inflow_long_press_gesture_times_" + com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId(), 0) != 0) goto L49;
        AnchorV3Param r9 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r9 == null) goto L35;
        String r10 = r9.getVideoId();
    L37:
        if (Intrinsics.areEqual(r10, r6.a()) == true) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(this.currentProductId, r6.d()) == false) goto L48;
        this.gestureGuideLiveData.setValue(new sd3.a(r1, this.currentProductId));
        return;
    L48:
        return;
    L35:
        r10 = null;
        goto L37
    L49:
        return;
    L46:
        return;
    L25:
        if (r8.length() == 0) goto L28;
        r3 = false;
        goto L28
    L45:
        return;
    L15:
        if (r5.length() == 0) goto L18;
        r7 = false;
        goto L19
    L43:
        return;
    L7:
        if (r2.length() == 0) goto L10;
        r4 = false;
        goto L11
    }

    public final void setAnchorV3Param(AnchorV3Param r4) {
        this.anchorV3Param.setValue(r4);
        PromotionProductLiveEntryStruct r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getEntranceInfo();
    L6:
        JSONObject r6 = z1.g(r5);
        if (r6 == null) goto L9;
        this.ecomSceneId = r6.optString("ecom_scene_id");
    L9:
        AnchorV3Param r7 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r7 == null) goto L24;
        List r1 = r7.getPromotions();
        if (r1 != null) goto L14;
    L16:
        List<? extends PromotionProductStruct> r2 = r7.getPromotions();
        if (r2 == null) goto L19;
        updatePromotion(r2);
    L19:
        PromotionProductAuthorEntriesStruct r8 = r7.getCurrentPromotion().getEntryInfo();
        if (r8 == null) goto L22;
        r0 = r8.getLiveEntry();
    L22:
        this.originalLiveEntry = r0;
        return;
    L14:
        if (r1.isEmpty() != true) goto L16;
        r7.setPromotions(CollectionsKt.listOf(r7.getCurrentPromotion()));
        goto L16
    L24:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setAutoExpand(int r1) {
        this.isAutoExpand = r1;
    }

    public final void setAutoExpandedLiveData(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isAutoExpandedLiveData = r2;
    }

    public final void setCouponPageSchema(String r1) {
        this.couponPageSchema = r1;
    }

    public final void setCurrentProductId(String r1) {
        this.currentProductId = r1;
    }

    public final void setEcomSceneId(String r1) {
        this.ecomSceneId = r1;
    }

    public final void setExpandedLiveData(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isExpandedLiveData = r2;
    }

    public final void setFirstLoadGuessULikeResourceCardList(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.firstLoadGuessULikeResourceCardList = r2;
    }

    public final void setFirstLoadingGuessULikeLiveData(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.firstLoadingGuessULikeLiveData = r2;
    }

    public final void setFlowFragment(Fragment r1) {
        this.flowFragment = r1;
    }

    public final void setGoodPriceCardList(List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.goodPriceCardList = r2;
    }

    public final void setGoodPriceCards(List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.goodPriceCards = r2;
    }

    public final void setGoodPriceStrips(List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.goodPriceStrips = r2;
    }

    public final void setGuessULikeDataList(final List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "guessULikeList");
        setState(new C02691(r2));
    }

    public final void setHalfScreenCouponPageSchema(String r1) {
        this.halfScreenCouponPageSchema = r1;
    }

    public final void setHasBindProductFeedGuessULike(boolean r1) {
        this.hasBindProductFeedGuessULike = r1;
    }

    public final void setHasEnterVideoDetailActivity(boolean r1) {
        this.hasEnterVideoDetailActivity = r1;
    }

    public final void setHasExpandInflow(boolean r1) {
        this.isHasExpandInflow = r1;
    }

    public final void setHasShowGuessCardPid(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hasShowGuessCardPid = r2;
    }

    public final void setHeadAnchorInflowFeedItem(rd3.a r1) {
        this.headAnchorInflowFeedItem = r1;
    }

    public final void setHeadImagePos(int r1) {
        this.headImagePos = r1;
    }

    public final void setHeaderList(List<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.headerList = r2;
    }

    public final void setInflowResume(boolean r1) {
        this.isInflowResume = r1;
    }

    public final void setInnerFlowPageStyle(InnerFlowPageStyleDTO r1) {
        this.innerFlowPageStyle = r1;
    }

    public final void setOperate(boolean r1) {
        this.isOperate = r1;
    }

    public final void setPreloadDataCenter(com.bytedance.android.shopping.feed.d r1) {
        this.preloadDataCenter = r1;
    }

    public final void setProductFeedGuessULikeMonitorName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.productFeedGuessULikeMonitorName = r2;
    }

    public final void setPromotion(PromotionProductStruct r1) {
        this.promotion = r1;
    }

    public final void setResourceCards(List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resourceCards = r2;
    }

    public final void setResumeTime(long r1) {
        this.resumeTime = r1;
    }

    public final void setSearchCard(rd3.a r1) {
        this.searchCard = r1;
    }

    public final void setSearchCardList(List<rd3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchCardList = r2;
    }

    public final void setSearchFilterPIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchFilterPIds = r2;
    }

    public final void setSearchFilterQueryIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchFilterQueryIds = r2;
    }

    public final void setShowProductFeedDragGestureLiveData(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showProductFeedDragGestureLiveData = r2;
    }

    public final void setShowedSimilarEntranceProductId(HashSet<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showedSimilarEntranceProductId = r2;
    }

    public final void setSkuPanelState(SkuRestoreState r1) {
        this.skuPanelState = r1;
    }

    public final void setSlideHeadImage(boolean r1) {
        this.isSlideHeadImage = r1;
    }

    public final void setToastLiveData(MutableLiveData<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.toastLiveData = r2;
    }

    public final void setTopicCardShowPosition(int r1) {
        this.topicCardShowPosition = r1;
    }

    public final void syncDynamic(boolean r4) {
        AnchorV3Param r0 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r0 == null) goto L13;
        AnchorV3PromotionRequestParam r1 = r0.getRequestParam();
        if (r1 == null) goto L14;
        AnchorV3Repository r2 = AnchorV3Repository.g;
        AnchorV3Param r3 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r3 == null) goto L10;
        String r5 = r3.getCurrentPromotionId();
    L11:
        AnchorV3Repository.b(r2, r1, r5).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r4));
        return;
    L10:
        r5 = null;
        goto L11
    L14:
        return;
    }

    public final void updateFloatMallVisibility(final boolean r2) {
        setState(new C02701(r2));
    }

    public final void setAnchorV3Param(MutableLiveData<AnchorV3Param> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorV3Param = r2;
    }

    public static final /* synthetic */ int access$getGuessULikeRank(ProductFeedViewModel r0, String r1) {
        return r0.getGuessULikeRank(r1);
    }

    public static final /* synthetic */ int access$getSearchCardPos(ProductFeedViewModel r0, String r1) {
        return r0.getSearchCardPos(r1);
    }

    public static final /* synthetic */ boolean access$isAdRequest(ProductFeedViewModel r0, AnchorV3PromotionRequestParam r1) {
        return r0.isAdRequest(r1);
    }

    public static final /* synthetic */ void access$loadResourceCard(ProductFeedViewModel r0, String r1) {
        r0.loadResourceCard(r1);
    }

    public static final /* synthetic */ void access$setGuessULikeCursor$p(ProductFeedViewModel r0, int r1) {
        r0.guessULikeCursor = r1;
    }

    public static final /* synthetic */ void access$setPage$p(ProductFeedViewModel r0, int r1) {
        r0.page = r1;
    }

    public static final /* synthetic */ void access$setSearchCardRunnable$p(ProductFeedViewModel r0, Runnable r1) {
        r0.searchCardRunnable = r1;
    }

    public static final /* synthetic */ void access$setState(ProductFeedViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$updatePromotion(ProductFeedViewModel r0, List r1) {
        r0.updatePromotion(r1);
    }

    public static final /* synthetic */ void access$withState(ProductFeedViewModel r0, Function1 r1) {
        r0.withState(r1);
    }

    private final void loadGuessULikeInternal(final boolean r2, final String r3) {
        withState(new C02681(this, r2, r3));
    }

    private final void postGoodPriceArea(InflowGuessFeedResponse r11, String r12) {
        final List<rd3.a> r0 = r11.getFeedItemAnchors();
        final ArrayList r3 = null;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L57;
        List<rd3.a> r1 = r0;
        Iterator<T> r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        rd3.a r5 = (rd3.a) r4.next();
        r5.b = r12;
        r5.c = this;
        GoodPriceCardOrStripType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r12, "scene");
        r5.e = CollectionsKt.listOf(new String[]{GoodPriceCardOrStripType.GOOD_PRICE_CARD_2.getType(), GoodPriceCardOrStripType.FAVOURITE_BAR.getType()}).contains(r12);
        rd3.f r6 = r11.getExtra();
        if (r6 == null) goto L13;
        String r7 = r6.a();
    L14:
        r5.d = r7;
        if (GoodPriceCardOrStripType.a.a(r12) == false) goto L9;
        yd3.p r8 = r5.i();
        if (r8 == null) goto L9;
        r8.a = 1001;
        goto L9
    L13:
        r7 = null;
        goto L14
    L19:
        GoodPriceCardOrStripType.Companion.getClass();
        if (GoodPriceCardOrStripType.a.a(r12) == false) goto L41;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r1.iterator();
    L23:
        if (r14.hasNext() == false) goto L37;
        rd3.a r2 = (rd3.a) r14.next();
        Promotion r9 = r2.f();
        if (r9 == null) goto L32;
        PromotionProductStruct r10 = r9.getPromotionInfo();
        if (r10 == null) goto L32;
        PromotionProductBaseStruct r15 = r10.getBaseInfo();
        if (r15 == null) goto L32;
        String r16 = r15.getProductId();
        if (r16 == null) goto L32;
    L34:
        if (this.hasShowGuessCardPid.contains(r16) == true) goto L23;
        r13.add(r2);
        this.goodPriceCardList.add(r2);
    L32:
        r16 = "";
        goto L34
    L37:
        if ((!r13.isEmpty()) == false) goto L39;
        r3 = r13;
    L39:
        if (r3 == null) goto L58;
        this.goodPriceCards = r13;
        setState(new ProductFeedViewModel$postGoodPriceArea$2$4$1(r3));
        return;
    L58:
        return;
    L41:
        Intrinsics.checkNotNullParameter(r12, "scene");
        if (CollectionsKt.listOf(new String[]{GoodPriceCardOrStripType.MAIN_PRODUCT_BAR.getType(), GoodPriceCardOrStripType.FAVOURITE_BAR.getType()}).contains(r12) == false) goto L60;
        this.goodPriceStrips = r0;
        setState(new ProductFeedViewModel$postGoodPriceArea$2$5(r0));
        return;
    L60:
        return;
    }

    private final Observable<InflowGuessFeedResponse> tryGetGoodPriceProdObservable(List<ud3.d> r21, String r22) {
        if (checkAndGetGoodPriceCardReqScene(r22) == true) goto L5;
    L80:
        return null;
    L5:
        if (r21.isEmpty() == true) goto L80;
        AnchorV3Param r1 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r1 == null) goto L15;
        ECLogExtraData r2 = r1.getLogExtraData();
        if (r2 == null) goto L15;
        String r3 = r2.getEnterFrom();
        if (r3 == null) goto L15;
        String r5 = r3;
    L16:
        AnchorV3Param r4 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r4 == null) goto L26;
        AnchorV3PromotionRequestParam r6 = r4.getRequestParam();
        if (r6 == null) goto L26;
        List r7 = r6.getGoodPriceParam();
        if (r7 == null) goto L26;
        String r8 = CollectionsKt.joinToString$default(r7, ",", null, null, 0, null, null, 62, null);
        if (r8 == null) goto L26;
        String r9 = r8;
    L27:
        AnchorV3Param r10 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r10 == null) goto L33;
        String r11 = r10.getVideoId();
        if (r11 == null) goto L33;
        String r12 = r11;
    L34:
        AnchorV3Param r13 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r13 == null) goto L40;
        String r14 = r13.getAuthorId();
        if (r14 == null) goto L40;
        String r15 = r14;
    L41:
        boolean r16 = true;
        boolean r17 = false;
        if (r5.length() != 0) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L47;
    L79:
        dm.a.a("req_good_price").i("params is empty");
        goto L80
    L47:
        if (r9.length() != 0) goto L49;
        boolean r19 = true;
    L50:
        if (r19 == true) goto L79;
        if (r12.length() != 0) goto L54;
        boolean r20 = true;
    L55:
        if (r20 == true) goto L79;
        if (r15.length() == 0) goto L60;
        r16 = false;
    L60:
        if (r16 == true) goto L79;
        GoodPriceApi.a.getClass();
        GoodPriceApi r23 = GoodPriceApi.a.a;
        if (r23 == null) goto L81;
        String r24 = com.bytedance.android.ec.hybrid.list.util.k.d(r21);
        AnchorV3Param r25 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r25 == null) goto L69;
        AnchorV3PromotionRequestParam r26 = r25.getRequestParam();
        if (r26 == null) goto L69;
        boolean r27 = r26.isAds();
    L70:
        AnchorV3Param r110 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r110 == null) goto L75;
        AnchorV3PromotionRequestParam r111 = r110.getRequestParam();
        if (r111 == null) goto L75;
        r17 = r111.isStar();
    L75:
        Observable<InflowGuessFeedResponse> r28 = r23.getGoodPriceProducts(r24, r17, r27, r5, r9, r12, r22, r15);
        if (r28 != null) goto L78;
        return null;
    L78:
        return r28.subscribeOn(Schedulers.io());
    L69:
        r27 = false;
        goto L70
    L81:
        return null;
    L54:
        r20 = false;
        goto L55
    L49:
        r19 = false;
        goto L50
    L44:
        r18 = false;
    L40:
        r15 = "";
    L33:
        r12 = "";
    L26:
        r9 = "";
    L15:
        r5 = "";
        goto L16
    }

    private final void tryReqGoodPrice(List<rd3.a> r2, String r3) {
        if ((!r2.isEmpty()) == false) goto L8;
        List<ud3.d> r4 = getReqBaseProduct(r2);
        if ((!r4.isEmpty()) == false) goto L9;
        tryLoadGoodPriceCardOrStrip(r4, r3);
        return;
    L9:
        return;
    }

    private final PromotionProductStruct updateMarketingBannerAndTip(PromotionProductStruct r3, SaveMoneyCardMarketingInfoResponse r4) {
        PromotionProductPrivilegesStruct r0 = r3.getPrivilegeInfo();
        if (r0 == null) goto L7;
        PromotionProductCouponsStruct r1 = r0.getCoupons();
        if (r1 == null) goto L7;
        MarketingBanner r2 = r1.getMarketingBanner();
    L8:
        if (r2 == null) goto L20;
        rd3.j r5 = r4.getMarketingInfo();
        if (r5 == null) goto L12;
        MarketingBanner r6 = r5.a();
    L13:
        if (r6 == null) goto L20;
        PromotionProductPrivilegesStruct r7 = r3.getPrivilegeInfo();
        if (r7 == null) goto L19;
        PromotionProductCouponsStruct r8 = r7.getCoupons();
        if (r8 == null) goto L19;
        r8.setMarketingBanner(r4.getMarketingInfo().a());
    L19:
        return r3;
    L12:
        r6 = null;
    L20:
        PromotionProductPrivilegesStruct r9 = r3.getPrivilegeInfo();
        if (r9 == null) goto L25;
        PromotionProductCouponsStruct r10 = r9.getCoupons();
        if (r10 == null) goto L25;
        MarketingTip r11 = r10.getMarketingTip();
    L26:
        if (r11 == null) goto L38;
        rd3.j r12 = r4.getMarketingInfo();
        if (r12 == null) goto L30;
        MarketingTip r13 = r12.b();
    L31:
        if (r13 == null) goto L38;
        PromotionProductPrivilegesStruct r14 = r3.getPrivilegeInfo();
        if (r14 == null) goto L37;
        PromotionProductCouponsStruct r15 = r14.getCoupons();
        if (r15 == null) goto L37;
        r15.setMarketingTip(r4.getMarketingInfo().b());
    L37:
        return r3;
    L30:
        r13 = null;
    L38:
        return null;
    L25:
        r11 = null;
    L7:
        r2 = null;
        goto L8
    }

    private final Pair<List<Long>, List<rd3.a>> updateMarketingBannerAndTipForGuessULike(List<rd3.a> r6, SaveMoneyCardMarketingInfoResponse r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L23;
        rd3.a r2 = (rd3.a) r8.next();
        Promotion r3 = r2.f();
        if (r3 == null) goto L21;
        PromotionProductStruct r4 = r3.getPromotionInfo();
        if (r4 == null) goto L21;
        PromotionProductStruct r5 = updateMarketingBannerAndTip(r4, r7);
        if (r5 == null) goto L21;
        Promotion r9 = r2.f();
        if (r9 == null) goto L14;
        r9.setPromotionInfo(r5);
    L14:
        PromotionProductBaseStruct r10 = r5.getBaseInfo();
        if (r10 == null) goto L19;
        String r11 = r10.getPromotionId();
        if (r11 == null) goto L19;
        long r12 = CastLongProtector.parseLong(r11);
    L20:
        r1.add(Long.valueOf(r12));
    L19:
        r12 = 0;
    L21:
        r0.add(r2);
        goto L4
    L23:
        return new Pair(r1, r0);
    }

    public final void handleGuessULikeResp(final InflowGuessFeedResponse r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "resp");
        if (r14.getStatusCode() == 0) goto L5;
    L6:
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        PromotionLogPbData r2 = r14.getLogPb();
        if (r2 == null) goto L9;
        String r3 = r2.getImprId();
    L10:
        Integer r4 = Integer.valueOf(r14.getStatusCode());
        String r5 = r14.getStatusMsg();
        r0.getClass();
        FeedProductEventTracker.C("load_product_feed_guessulike_api_fail", this, r3, r4, r5);
    L11:
        boolean r1 = isFirstLoadingGuessULike();
        final ArrayList r6 = new ArrayList();
        final ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r14.getFeedItemAnchors().iterator();
    L12:
        boolean r9 = false;
        if (r8.hasNext() == false) goto L72;
        final rd3.a r10 = (rd3.a) r8.next();
        rd3.f r11 = r14.getExtra();
        if (r11 == null) goto L17;
        String r12 = r11.a();
    L18:
        r10.d = r12;
        r10.c = this;
        int r13 = com.bytedance.android.shopping.feed.viewmodel.a.a;
        GuessULikeAdData r16 = r10.a();
        if (r16 == null) goto L21;
        String r17 = r16.getRawData();
    L22:
        r10.a = com.bytedance.android.shopping.feed.viewmodel.a.a(r17);
        if (r1 == false) goto L58;
        Integer r18 = r10.getType();
        if (r18 == null) goto L58;
        if (r18.intValue() != 23) goto L58;
        yd3.p r19 = r10.i();
        if (r19 != null) goto L32;
    L50:
        Lazy r20 = ResourceCardFreqController.a;
        if (ResourceCardFreqController.a(r10.i()) == false) goto L57;
        r7.add(r10);
        yd3.p r21 = r10.i();
        if (r21 == null) goto L57;
        if (r21.getType() != 9) goto L57;
        setState(new ProductFeedViewModel$handleGuessULikeResp$1$1(r10));
    L57:
        ArrayList r22 = new ArrayList();
        r22.addAll(this.firstLoadGuessULikeResourceCardList);
        r22.addAll(r7);
        this.firstLoadGuessULikeResourceCardList = r22;
        goto L12
    L32:
        if (r19.getType() != 7) goto L50;
        MallDivertShowJudge.h.getClass();
        MallDivertShowJudge r23 = MallDivertShowJudge.a.a();
        yd3.p r24 = r10.i();
        if (r24 == null) goto L38;
        yd3.p.b r25 = r24.g();
        if (r25 == null) goto L38;
        String r26 = r25.b();
    L39:
        r23.f = Intrinsics.areEqual(r26, "1");
        MallDivertShowJudge r27 = MallDivertShowJudge.a.a();
        if (r27.f == false) goto L43;
    L47:
        r9 = true;
    L48:
        if (r9 == false) goto L57;
        r7.add(r10);
        goto L57
    L43:
        if (Intrinsics.areEqual(r27.e, r27.d) == true) goto L47;
        if ((System.currentTimeMillis() - r27.c) <= r27.b) goto L48;
    L38:
        r26 = null;
    L58:
        Integer r28 = r10.getType();
        if (r28 == null) goto L63;
        if (r28.intValue() == 5) goto L12;
    L63:
        Integer r29 = r10.getType();
        if (r29 == null) goto L70;
        if (r29.intValue() != 23) goto L70;
        Lazy r30 = ResourceCardFreqController.a;
        if (ResourceCardFreqController.a(r10.i()) == false) goto L12;
    L70:
        r6.add(r10);
        goto L12
    L21:
        r17 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    L72:
        if (checkIsReqAllGuessGoodPriceStrip() == false) goto L75;
        tryReqGoodPrice(r6, GoodPriceCardOrStripType.FAVOURITE_BAR.getType());
    L75:
        if (checkIsReqAllGuessGoodPriceCard() == false) goto L77;
        tryReqGoodPrice(r6, GoodPriceCardOrStripType.GOOD_PRICE_CARD_2.getType());
    L77:
        setState(new AnonymousClass2(r6, r7, r14, r15));
        rd3.l r110 = r14.getPage();
        if (r110 == null) goto L82;
        Integer r111 = r110.a();
        if (r111 == null) goto L82;
        int r112 = r111.intValue();
    L83:
        this.guessULikeCursor = r112;
        this.innerGuessULikeFiltersHelper.b(r14.getFeedItemAnchors());
        ArrayList<String> r113 = d0.a;
        List<rd3.a> r114 = r14.getFeedItemAnchors();
        Intrinsics.checkNotNullParameter(r114, "productList");
        Iterator<T> r115 = r114.iterator();
    L85:
        if (r115.hasNext() == false) goto L106;
        Promotion r116 = ((rd3.a) r115.next()).f();
        if (r116 == null) goto L85;
        PromotionProductStruct r117 = r116.getPromotionInfo();
        if (r117 == null) goto L85;
        PromotionProductExtraStruct r118 = r117.getExtraInfo();
        if (r118 == null) goto L85;
        ProductTopicInfo r119 = r118.getTopicInfo();
        if (r119 == null) goto L85;
        List r120 = r119.getTopicItemList();
        if (r120 == null) goto L85;
        TopicItemInfo r121 = (TopicItemInfo) CollectionsKt.firstOrNull(r120);
        if (r121 == null) goto L85;
        String r122 = r121.getId();
        if (r122 == null) goto L85;
        ArrayList<String> r31 = d0.a;
        if ((!r31.isEmpty()) == true) goto L103;
    L105:
        r31.add(r122);
        goto L85
    L103:
        if (r31.size() < 100) goto L105;
        ListProtector.remove(r31, 0);
        goto L105
    L106:
        this.page++;
        com.bytedance.android.shopping.feed.utils.g.a.clear();
        this.isLoadingGuessULike = false;
        return;
    L82:
        r112 = 0;
        goto L83
    L9:
        r3 = null;
        goto L10
    L5:
        if (r14.getFeedItemAnchors().isEmpty() == false) goto L11;
        goto L6
    }

    public final void loadGuessULike(boolean r2, String r3) {
        if (this.isLoadingGuessULike == false) goto L5;
        return;
    L5:
        this.isLoadingGuessULike = true;
        withState(new C02671(this));
        if (this.preloadDataCenter != null) goto L8;
    L10:
        loadGuessULikeInternal(r2, r3);
        return;
    L8:
        if (isFirstLoadingGuessULike() == false) goto L10;
        this.firstLoadingGuessULikeLiveData.postValue(Boolean.TRUE);
    }

    public final void tryLoadGoodPriceCardOrStrip(List<ud3.d> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "baseProducts");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Observable<InflowGuessFeedResponse> r4 = tryGetGoodPriceProdObservable(r2, r3);
        if (r4 == null) goto L8;
        Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L9;
        r5.subscribe(new g(this, r3), h.a);
        return;
    L9:
        return;
    }

    public final void tryLoadGuessSearchCardV2(rd3.a r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Observable r0 = null;
        this.searchCardRunnable = null;
        if (r7 != null) goto L5;
        return;
    L5:
        Promotion r1 = r7.f();
        if (r1 == null) goto L51;
        PromotionProductStruct r2 = r1.getPromotionInfo();
        if (r2 == null) goto L52;
        PromotionProductBaseStruct r3 = r2.getBaseInfo();
        if (r3 == null) goto L59;
        List<ud3.d> r4 = getReqBaseProduct(CollectionsKt.listOf(r7));
        AnchorV3Param r5 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r5 == null) goto L19;
        AnchorV3PromotionRequestParam r6 = r5.getRequestParam();
        if (r6 == null) goto L19;
        Integer r9 = r6.getGoodPriceCardGuessLikeOpt();
        if (r9 == null) goto L19;
        int r10 = r9.intValue();
    L20:
        if (r10 != 0) goto L24;
        Observable<InflowGuessFeedResponse> r11 = tryGetGoodPriceProdObservable(r4, r8);
        if (r11 == null) goto L24;
        Observable r12 = r11.onErrorReturn(i.a);
    L25:
        Set<String> r13 = this.markProductIdToProdDetail;
        String r14 = r3.getProductId();
        String r15 = "";
        if (r14 != null) goto L29;
        r14 = "";
    L29:
        if (r13.contains(r14) == true) goto L44;
        if (r12 == null) goto L44;
        Observable<InflowGuessFeedResponse> r16 = tryGetSearchCardObservable(r3.getProductId());
        if (r16 == null) goto L34;
        r0 = r16.onErrorReturn(o.a);
    L34:
        if (r0 != null) goto L38;
        Observable r17 = r12.observeOn(AndroidSchedulers.mainThread());
        if (r17 == null) goto L53;
        r17.subscribe(new j(this, r8), k.a);
        return;
    L53:
        return;
    L38:
        Observable r18 = Observable.zip(r0, r12, l.a);
        if (r18 == null) goto L55;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L56;
        r19.subscribe(new m(this, r3, r8), n.a);
        return;
    L56:
        return;
    L55:
        return;
    L44:
        if (r7.q == true) goto L58;
        String r20 = r3.getProductId();
        if (r20 == null) goto L49;
        r15 = r20;
    L49:
        tryLoadSearchCard(r15);
        return;
    L58:
        return;
    L24:
        r12 = null;
    L19:
        r10 = 0;
        goto L20
    L59:
        return;
    L52:
        return;
    }

    public static final /* synthetic */ void access$postGoodPriceArea(ProductFeedViewModel r0, InflowGuessFeedResponse r1, String r2) {
        r0.postGoodPriceArea(r1, r2);
    }

    public static final /* synthetic */ PromotionProductStruct access$updateMarketingBannerAndTip(ProductFeedViewModel r0, PromotionProductStruct r1, SaveMoneyCardMarketingInfoResponse r2) {
        return r0.updateMarketingBannerAndTip(r1, r2);
    }

    public static final /* synthetic */ Pair access$updateMarketingBannerAndTipForGuessULike(ProductFeedViewModel r0, List r1, SaveMoneyCardMarketingInfoResponse r2) {
        return r0.updateMarketingBannerAndTipForGuessULike(r1, r2);
    }

    public final String buildPhotoSearchSchema(rd3.a r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "filePath");
        Intrinsics.checkNotNullParameter(r11, "imageUrl");
        Uri r0 = l0.c(UriProtector.parse("aweme://search/photo"), "enter_method", "inflow_find_similar");
        AnchorV3Param r1 = (AnchorV3Param) this.anchorV3Param.getValue();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getVideoId();
    L6:
        Uri r4 = l0.c(r0, "group_id", r3);
        AnchorV3Param r5 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r5 == null) goto L9;
        String r6 = r5.getAuthorId();
    L10:
        Uri r7 = l0.c(r4, "author_id", r6);
        if (r9 == null) goto L19;
        Promotion r8 = r9.f();
        if (r8 == null) goto L19;
        PromotionProductStruct r12 = r8.getPromotionInfo();
        if (r12 == null) goto L19;
        PromotionProductBaseStruct r13 = r12.getBaseInfo();
        if (r13 == null) goto L19;
        String r14 = r13.getProductId();
    L20:
        Uri r15 = l0.c(r7, PdpOpenThirdParam.KEY_PRODUCT_ID, r14);
        JsonObject r16 = new JsonObject();
        r16.addProperty("photo_search_previous_page", "product_flow_page");
        AnchorV3Param r17 = (AnchorV3Param) this.anchorV3Param.getValue();
        String r18 = "";
        if (r17 == null) goto L26;
        AnchorV3PromotionRequestParam r19 = r17.getRequestParam();
        if (r19 == null) goto L26;
        String r20 = r19.getEnterFrom();
        if (r20 == null) goto L26;
    L27:
        r16.addProperty("enter_from_second", "product_flow_page_".concat(r20));
        Uri r110 = l0.c(l0.c(l0.c(l0.c(l0.c(l0.c(r15, "search_scan_params", r16.toString()), SimilarProductParam.ENTER_FROM, "search_order_center_product_flow_page"), "search_channel", "ecom_search_similar_product"), "file_path", r10), "search_image_url", r11), "search_type", "search_order_center_product_flow_page");
        JsonObject r111 = new JsonObject();
        AnchorV3Param r21 = (AnchorV3Param) this.anchorV3Param.getValue();
        if (r21 == null) goto L31;
        String r22 = r21.getVideoId();
        if (r22 == null) goto L31;
    L32:
        r111.addProperty("group_id", r22);
        if (r9 == null) goto L42;
        Promotion r23 = r9.f();
        if (r23 == null) goto L42;
        PromotionProductStruct r24 = r23.getPromotionInfo();
        if (r24 == null) goto L42;
        PromotionProductBaseStruct r25 = r24.getBaseInfo();
        if (r25 == null) goto L42;
        String r26 = r25.getProductId();
        if (r26 == null) goto L42;
    L43:
        r111.addProperty(PdpOpenThirdParam.KEY_PRODUCT_ID, r26);
        if (r9 == null) goto L47;
        String r27 = r9.d;
        if (r27 == null) goto L47;
    L48:
        r111.addProperty("request_id", r27);
        AnchorV3Param r28 = m907getAnchorV3Param();
        if (r28 == null) goto L54;
        ECLogExtraData r29 = r28.getLogExtraData();
        if (r29 == null) goto L54;
        String r30 = r29.getEnterFrom();
        if (r30 == null) goto L54;
    L55:
        r111.addProperty("chnid", r30);
        Uri r112 = l0.c(r110, "search_passthrough_params", r111.toString());
        if (r9 == null) goto L58;
        r2 = r9.d;
    L58:
        Uri r31 = l0.c(r112, "request_id", r2);
        AnchorV3Param r113 = m907getAnchorV3Param();
        if (r113 == null) goto L67;
        ECLogExtraData r114 = r113.getLogExtraData();
        if (r114 == null) goto L67;
        String r115 = r114.getEnterFrom();
        if (r115 == null) goto L67;
        r18 = r115;
    L67:
        return l0.c(r31, "chnid", r18).toString();
    L54:
        r30 = "";
    L47:
        r27 = "";
    L42:
        r26 = "";
    L31:
        r22 = "";
    L26:
        r20 = "";
    L19:
        r14 = null;
        goto L20
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ void syncDynamic$default(ProductFeedViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.syncDynamic(r1);
    }

    public final void handleSearchCardResource(final InflowGuessFeedResponse r5, int r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "resp");
        Intrinsics.checkNotNullParameter(r7, "productId");
        rd3.a r0 = (rd3.a) CollectionsKt.firstOrNull(r5.getFeedItemAnchors());
        if (r0 == null) goto L11;
        yd3.p r1 = r0.i();
        if (r1 == null) goto L11;
        yd3.q r2 = r1.o();
        if (r2 == null) goto L11;
        ArrayList<SearchItem> r3 = r2.c();
        if (r3 == null) goto L11;
        int r4 = r3.size();
    L13:
        if (r4 < 3) goto L51;
        Iterator<T> r9 = r5.getFeedItemAnchors().iterator();
    L16:
        if (r9.hasNext() == false) goto L30;
        rd3.a r10 = (rd3.a) r9.next();
        rd3.f r11 = r5.getExtra();
        if (r11 == null) goto L20;
        String r12 = r11.a();
    L21:
        r10.d = r12;
        r10.c = this;
        yd3.p r13 = r10.i();
        if (r13 == null) goto L24;
        r13.t(r6);
    L24:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r10.h = r7;
        PromotionLogPbData r14 = r5.getLogPb();
        if (r14 == null) goto L28;
        String r15 = r14.getImprId();
        if (r15 == null) goto L28;
    L29:
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r10.j = r15;
        String r16 = String.valueOf(r8);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r10.i = r16;
    L28:
        r15 = "";
        goto L29
    L20:
        r12 = null;
        goto L21
    L30:
        rd3.a r17 = (rd3.a) CollectionsKt.firstOrNull(r5.getFeedItemAnchors());
        this.searchCard = r17;
        if (r17 == null) goto L42;
        yd3.p r18 = r17.i();
        if (r18 == null) goto L42;
        yd3.q r19 = r18.o();
        if (r19 == null) goto L42;
        ArrayList<SearchItem> r20 = r19.c();
        if (r20 == null) goto L42;
        Iterator<T> r21 = r20.iterator();
    L40:
        if (r21.hasNext() == false) goto L42;
        SearchItem r22 = (SearchItem) r21.next();
        this.searchFilterPIds.add(String.valueOf(r22.getProductId()));
        this.searchFilterQueryIds.add(String.valueOf(r22.getQueryId()));
    L42:
        rd3.a r23 = (rd3.a) CollectionsKt.firstOrNull(r5.getFeedItemAnchors());
        if (r23 == null) goto L45;
        this.searchCardList.add(r23);
    L45:
        setState(new C02664(r5));
        return;
    L51:
        return;
    L11:
        r4 = 0;
        goto L13
    }

    public static /* synthetic */ void loadGuessULike$default(ProductFeedViewModel r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.loadGuessULike(r1, r2);
    }

    public static /* synthetic */ void loadGuessULikeInternal$default(ProductFeedViewModel r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.loadGuessULikeInternal(r1, r2);
    }
}

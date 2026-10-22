package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragmentV2;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetchJobKey;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventContext;
import com.bytedance.android.shopping.store.tabkit.mixframe.TabKitMixFrameTabFragment;
import com.bytedance.android.shopping.store.tabkit.model.r;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.t;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.TabKitDialogView;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 ù\u00012\u00020\u0001:\u0002ú\u0001B\t¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\tJ\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001d2\u0006\u0010\u001c\u001a\u00020\u0006J\u0017\u0010\u001f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\tJ\u0019\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b'\u0010%J\u0017\u0010(\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b(\u0010)J\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u0010\u0010.\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010/\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\tR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0006¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010C\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020N068\u0006¢\u0006\f\n\u0004\bO\u00108\u001a\u0004\bP\u0010:R)\u0010Q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N0\u001d068\u0006¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010:R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\f\n\u0004\bS\u00108\u001a\u0004\bT\u0010:R\u0017\u0010V\u001a\u00020U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u0006068\u0006¢\u0006\f\n\u0004\bZ\u00108\u001a\u0004\b[\u0010:R\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\\068\u0006¢\u0006\f\n\u0004\b]\u00108\u001a\u0004\b^\u0010:R\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\\068\u0006¢\u0006\f\n\u0004\b_\u00108\u001a\u0004\b`\u0010:R)\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001d068\u0006¢\u0006\f\n\u0004\ba\u00108\u001a\u0004\bb\u0010:R$\u0010c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010i\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010\u0017\"\u0004\bl\u0010mR'\u0010q\u001a\u0012\u0012\u0004\u0012\u00020o0nj\b\u0012\u0004\u0012\u00020o`p8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR'\u0010v\u001a\u0012\u0012\u0004\u0012\u00020u0nj\b\u0012\u0004\u0012\u00020u`p8\u0006¢\u0006\f\n\u0004\bv\u0010r\u001a\u0004\bw\u0010tR\u0017\u0010y\u001a\u00020x8\u0006¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0019\u0010~\u001a\u00020}8\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R:\u0010\u0084\u0001\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0082\u0001j\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R:\u0010\u0088\u0001\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0082\u0001j\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0085\u0001\u001a\u0006\b\u0089\u0001\u0010\u0087\u0001R<\u0010\u008b\u0001\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u008a\u00010\u0082\u0001j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u008a\u0001`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u0085\u0001\u001a\u0006\b\u008c\u0001\u0010\u0087\u0001R)\u0010\u008d\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008d\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R)\u0010\u0092\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008e\u0001\u001a\u0006\b\u0093\u0001\u0010\u008f\u0001\"\u0006\b\u0094\u0001\u0010\u0091\u0001R)\u0010\u0095\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008e\u0001\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0091\u0001R \u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u0098\u0001\u00108\u001a\u0005\b\u0098\u0001\u0010:R \u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u0099\u0001\u00108\u001a\u0005\b\u0099\u0001\u0010:R \u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\t068\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u00108\u001a\u0005\b\u009a\u0001\u0010:R)\u0010\u009c\u0001\u001a\u0011\u0012\r\u0012\u000b \u009b\u0001*\u0004\u0018\u00010\t0\t068\u0006¢\u0006\u000e\n\u0005\b\u009c\u0001\u00108\u001a\u0005\b\u009d\u0001\u0010:R \u0010¡\u0001\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010\u008f\u0001R*\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R \u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f068\u0006¢\u0006\u000e\n\u0005\b©\u0001\u00108\u001a\u0005\bª\u0001\u0010:R,\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001a\u0010²\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010jR\u001c\u0010³\u0001\u001a\u00020\u00188\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R)\u0010Å\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u008e\u0001\u001a\u0006\bÆ\u0001\u0010\u008f\u0001\"\u0006\bÇ\u0001\u0010\u0091\u0001R\u001e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020\"0È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R^\u0010Ì\u0001\u001aD\u0012\u0004\u0012\u00020\u0018\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ë\u00010nj\t\u0012\u0005\u0012\u00030Ë\u0001`p0\u0082\u0001j!\u0012\u0004\u0012\u00020\u0018\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030Ë\u00010nj\t\u0012\u0005\u0012\u00030Ë\u0001`p`\u0083\u00018\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010\u0085\u0001\u001a\u0006\bÍ\u0001\u0010\u0087\u0001R*\u0010Î\u0001\u001a\u0012\u0012\u0004\u0012\u00020+0nj\b\u0012\u0004\u0012\u00020+`p8\u0006¢\u0006\u000e\n\u0005\bÎ\u0001\u0010r\u001a\u0005\bÏ\u0001\u0010tR+\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010´\u0001\u001a\u0006\bÑ\u0001\u0010¶\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R)\u0010Ô\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010\u008e\u0001\u001a\u0006\bÔ\u0001\u0010\u008f\u0001\"\u0006\bÕ\u0001\u0010\u0091\u0001R)\u0010Ö\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010\u008e\u0001\u001a\u0006\bÖ\u0001\u0010\u008f\u0001\"\u0006\b×\u0001\u0010\u0091\u0001R+\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010´\u0001\u001a\u0006\bÙ\u0001\u0010¶\u0001\"\u0006\bÚ\u0001\u0010Ó\u0001R$\u0010Ü\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0018\u0010ß\u0001\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010fR\u0016\u0010â\u0001\u001a\u0004\u0018\u00010\u000f8F¢\u0006\b\u001a\u0006\bà\u0001\u0010á\u0001R\u0014\u0010ã\u0001\u001a\u00020\t8F¢\u0006\b\u001a\u0006\bã\u0001\u0010\u008f\u0001R\u0014\u0010å\u0001\u001a\u00020\t8F¢\u0006\b\u001a\u0006\bä\u0001\u0010\u008f\u0001R\u0015\u0010ç\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010fR\u0015\u0010é\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bè\u0001\u0010fR\u0015\u0010ë\u0001\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0007\u001a\u0005\bê\u0001\u0010fR\u0017\u0010ï\u0001\u001a\u0005\u0018\u00010ì\u00018F¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0016\u0010ò\u0001\u001a\u0004\u0018\u00010\"8F¢\u0006\b\u001a\u0006\bð\u0001\u0010ñ\u0001R\u001b\u0010ö\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060ó\u00018F¢\u0006\b\u001a\u0006\bô\u0001\u0010õ\u0001¨\u0006û\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lcom/bytedance/android/shopping/store/tabkit/model/z;", "tabsResponse", "", "filterErrorTabFragment", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "tab1", "tab2", "", "checkTabValid", "Landroid/os/Bundle;", "arguments", "initPrefetchJobKey", "initMonitor", "", "tabId", "Lcom/bytedance/android/shopping/store/tabkit/model/v;", "getTabState", "(Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/tabkit/model/v;", "setTabKitData", "", "getTabKitMonitorId", "()Ljava/lang/Long;", "", "bundleUrl", "isAnchorTab", "buildBundleUrlWithRouterParams", "tab", "Lkotlin/Pair;", "getTabIndex", "isTabAlreadyShow", "(Ljava/lang/Integer;)Z", "tryCreate", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "getTabFragment", "getTabById", "(Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/tabkit/model/k;", "position", "getTrulyTabByPosition", "getTabTrulyIndex", "(Ljava/lang/Integer;)I", "getViewPagerTrulyPosition", "Lcom/bytedance/android/shopping/store/tabkit/g;", "listener", "addTabKitLifeListener", "prepare", "init", "removeMonitor", "clearFragments", "notifyLandingFinished", "notifyLandingStart", "notifyPageLandingFinished", "isRouterParamsInitialized", "Landroidx/lifecycle/MutableLiveData;", "screenState", "Landroidx/lifecycle/MutableLiveData;", "getScreenState", "()Landroidx/lifecycle/MutableLiveData;", "tabResponse", "getTabResponse", "Lcom/bytedance/android/shopping/store/tabkit/h;", "interceptorHelper", "Lcom/bytedance/android/shopping/store/tabkit/h;", "getInterceptorHelper", "()Lcom/bytedance/android/shopping/store/tabkit/h;", "Lcom/bytedance/android/shopping/store/tabkit/i;", "kvStorage", "Lcom/bytedance/android/shopping/store/tabkit/i;", "getKvStorage", "()Lcom/bytedance/android/shopping/store/tabkit/i;", "Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "routerParams", "Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "getRouterParams", "()Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "setRouterParams", "(Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;)V", "", "screenOffsetFactor", "getScreenOffsetFactor", "screenOffset", "getScreenOffset", "loadStatus", "getLoadStatus", "Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "eventContext", "Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "getEventContext", "()Lcom/bytedance/android/shopping/store/tabkit/events/TabKitEventContext;", "currentHomeTab", "getCurrentHomeTab", "Lcom/bytedance/android/shopping/store/tabkit/model/y;", "currentTab", "getCurrentTab", "currentTabAfter", "getCurrentTabAfter", "foldScreenSize", "getFoldScreenSize", "lastTab", "Lcom/bytedance/android/shopping/store/tabkit/model/k;", "getLastTab", "()Lcom/bytedance/android/shopping/store/tabkit/model/k;", "setLastTab", "(Lcom/bytedance/android/shopping/store/tabkit/model/k;)V", "lastTimeStamp", "Ljava/lang/Long;", "getLastTimeStamp", "setLastTimeStamp", "(Ljava/lang/Long;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", "Lkotlin/collections/ArrayList;", "lynxCards", "Ljava/util/ArrayList;", "getLynxCards", "()Ljava/util/ArrayList;", "Lti/l;", "hybridComponents", "getHybridComponents", "Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "jsEventStub", "Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "getJsEventStub", "()Lcom/bytedance/android/shopping/store/tabkit/bridge/c;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "jsBridge", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "getJsBridge", "()Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordedEventsMap", "Ljava/util/HashMap;", "getRecordedEventsMap", "()Ljava/util/HashMap;", "navBarVisibilityMap", "getNavBarVisibilityMap", "Lcom/bytedance/android/shopping/store/tabkit/model/d;", "topTabBarVisibilityMap", "getTopTabBarVisibilityMap", "isAnchorFinished", "Z", "()Z", "setAnchorFinished", "(Z)V", "firstSetData", "getFirstSetData", "setFirstSetData", "noRadius", "getNoRadius", "setNoRadius", "isUseNativeTopBar", "isUseNativeBottomBar", "isLandingFinished", "kotlin.jvm.PlatformType", "pageLandingFinished", "getPageLandingFinished", "landingFinishedOpt$delegate", "Lkotlin/Lazy;", "getLandingFinishedOpt", "landingFinishedOpt", "Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "abilityConfig", "Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "getAbilityConfig", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;", "setAbilityConfig", "(Lcom/bytedance/android/shopping/store/tabkit/TabKitAbilityConfig;)V", "tabSwitchMode", "getTabSwitchMode", "Lok3/a;", "tabKitMonitor", "Lok3/a;", "getTabKitMonitor", "()Lok3/a;", "setTabKitMonitor", "(Lok3/a;)V", "tabKitMonitorId", "tabsContainerId", "Ljava/lang/String;", "getTabsContainerId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "tabkitPrefetchJobKey", "Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "getTabkitPrefetchJobKey", "()Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;", "setTabkitPrefetchJobKey", "(Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetchJobKey;)V", "Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "tabKitComponentFactory", "Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "getTabKitComponentFactory", "()Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;", "setTabKitComponentFactory", "(Lcom/bytedance/android/shopping/store/tabkit/ITabKitComponentFactory;)V", "clickCloseBtn", "getClickCloseBtn", "setClickCloseBtn", "Landroid/util/SparseArray;", "tabFragmentsMap", "Landroid/util/SparseArray;", "Lcom/bytedance/android/shopping/store/tabkit/view/TabKitDialogView;", "dialogsMap", "getDialogsMap", "tabKitLifeListeners", "getTabKitLifeListeners", "marketingPageId", "getMarketingPageId", "setMarketingPageId", "(Ljava/lang/String;)V", "isLitePage", "setLitePage", "isFoldPage", "setFoldPage", "foldType", "getFoldType", "setFoldType", "Ljava/util/concurrent/ConcurrentHashMap;", "tabStates", "Ljava/util/concurrent/ConcurrentHashMap;", "getDefaultAnchorTab", "defaultAnchorTab", "getAnchorTabId", "()Ljava/lang/Integer;", "anchorTabId", "isFullScreen", "getCanShowSwipeIndicator", "canShowSwipeIndicator", "getTargetAnchorTab", "targetAnchorTab", "getAnchorTab", "anchorTab", "getAnchorHomeTab", "anchorHomeTab", "Lcom/bytedance/android/shopping/store/tabkit/model/r;", "getTabDowngradeConfig", "()Lcom/bytedance/android/shopping/store/tabkit/model/r;", "tabDowngradeConfig", "getCurrentSelectedFragment", "()Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "currentSelectedFragment", "", "getHomeTabs", "()Ljava/util/List;", "homeTabs", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitViewModel extends QViewModel {
    public static final a Companion = null;
    public TabKitAbilityConfig abilityConfig;
    private boolean clickCloseBtn;
    private final MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> currentHomeTab;
    private final MutableLiveData<y> currentTab;
    private final MutableLiveData<y> currentTabAfter;
    private final HashMap<String, ArrayList<TabKitDialogView>> dialogsMap;
    private final TabKitEventContext eventContext;
    private boolean firstSetData;
    private final MutableLiveData<Pair<Integer, Integer>> foldScreenSize;
    private String foldType;
    private final ArrayList<ti.l> hybridComponents;
    private final h interceptorHelper;
    private boolean isAnchorFinished;
    private boolean isFoldPage;
    private final MutableLiveData<Boolean> isLandingFinished;
    private boolean isLitePage;
    private final MutableLiveData<Boolean> isUseNativeBottomBar;
    private final MutableLiveData<Boolean> isUseNativeTopBar;
    private final TabKitBridge jsBridge;
    private final com.bytedance.android.shopping.store.tabkit.bridge.c jsEventStub;
    private final i kvStorage;
    private final Lazy landingFinishedOpt$delegate;
    private com.bytedance.android.shopping.store.tabkit.model.k lastTab;
    private Long lastTimeStamp;
    private final MutableLiveData<Integer> loadStatus;
    private final ArrayList<ECLynxCard> lynxCards;
    private String marketingPageId;
    private final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, Boolean> navBarVisibilityMap;
    private boolean noRadius;
    private final MutableLiveData<Boolean> pageLandingFinished;
    private final HashMap<String, Boolean> recordedEventsMap;
    public TabKitRouterParams routerParams;
    private final MutableLiveData<Pair<Float, Float>> screenOffset;
    private final MutableLiveData<Float> screenOffsetFactor;
    private final MutableLiveData<Integer> screenState;
    private final SparseArray<TabKitTabFragment> tabFragmentsMap;
    private ITabKitComponentFactory tabKitComponentFactory;
    private final ArrayList<g> tabKitLifeListeners;
    private ok3.a tabKitMonitor;
    private Long tabKitMonitorId;
    private final MutableLiveData<z> tabResponse;
    private final ConcurrentHashMap<Integer, v> tabStates;
    private final MutableLiveData<Integer> tabSwitchMode;
    private TabkitPrefetchJobKey tabkitPrefetchJobKey;
    private final String tabsContainerId;
    private final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> topTabBarVisibilityMap;

    public static final class a {
        public a() {
        }

        public static String a(String r8, TabKitRouterParams r9, boolean r10, boolean r11, boolean r12) {
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L32
            ArrayList r5 = new ArrayList();     // Catch: Throwable -> L32
            CollectionsKt.addAll(r5, new String[]{"anchor_url", "ssr_url", "na_prefetch_cert"});     // Catch: Throwable -> L32
            if (r10 == true) goto L10;
            if (r12 == false) goto L7;
            r5.add("source_btm_token");     // Catch: Throwable -> L32
        L7:
            List<String> r13 = hk3.a.d().a(r9.getBizTag());     // Catch: Throwable -> L32
            if (r13 == null) goto L10;
            r5.addAll(r13);     // Catch: Throwable -> L32
        L10:
            Uri r14 = UriProtector.parse(r8);     // Catch: Throwable -> L32
            Uri.Builder r15 = r14.buildUpon();     // Catch: Throwable -> L32
            Set r16 = UriProtector.getQueryParameterNames(r14);     // Catch: Throwable -> L32
            ArrayList r6 = new ArrayList(r9.getParamsMap().keySet());     // Catch: Throwable -> L32
            r6.removeAll(r5);     // Catch: Throwable -> L32
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L32
        L12:
            if (r7.hasNext() == false) goto L18;
            String r17 = (String) r7.next();     // Catch: Throwable -> L32
            if (r16.contains(r17) == true) goto L12;
            r15.appendQueryParameter(r17, r9.getParamsMap().get(r17));     // Catch: Throwable -> L32
            goto L12
        L18:
            if (r16.contains("disable_final_detect_when_detached") == true) goto L21;
            r15.appendQueryParameter("disable_final_detect_when_detached", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L32
        L21:
            if (r16.contains("ec_tabkit_container") == true) goto L24;
            r15.appendQueryParameter("ec_tabkit_container", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L32
        L24:
            if (r16.contains("loader_name") == true) goto L27;
            r15.appendQueryParameter("loader_name", "forest");     // Catch: Throwable -> L32
        L27:
            if (r16.contains("na_prefetch_sync_update") == true) goto L30;
            if (r11 == false) goto L30;
            r15.appendQueryParameter("na_prefetch_sync_update", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L32
        L30:
            return r15.toString();
        L32:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return r8;
        }
    }

    public static final class b implements ITabKitComponentFactory {
        public b() {
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final boolean getDisableBottomBar() {
            return false;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final BottomTabItemView createBottomTabItemView(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r5, "context");
            AttributeSet r3 = null;
            return new BottomTabItemView(r5, r3, 6, 0);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final TopTabItemView createTopTabItemView(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r5, "context");
            AttributeSet r3 = null;
            return new TopTabItemView(r5, r3, 6, 0);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
        public final TabKitTabFragment createTab(com.bytedance.android.shopping.store.tabkit.model.k r7, boolean r8, TabKitAbilityConfig r9) {
            Intrinsics.checkNotNullParameter(r7, "tab");
            Intrinsics.checkNotNullParameter(r9, "config");
            Intrinsics.checkNotNullParameter(r7, "tab");
            Intrinsics.checkNotNullParameter(r9, "config");
            s r1 = r7.f();
            String r2 = null;
            if (r1 == null) goto L5;
            Integer r3 = r1.c();
        L7:
            if (r3 != null) goto L10;
        L23:
            boolean r4 = r9.b("btm_custom_page_v2");
            dm.a.a("ITabKitComponentFactory").i("createTab, enableBtmV2=" + r4);
            boolean r5 = false;
            if (r4 == false) goto L43;
            TabKitAnnieXTabFragment.Companion.getClass();
            if (TabKitAnnieXTabFragment.a.a(r7, r9) == false) goto L35;
            TabKitAnnieXTabFragmentV2.a r10 = TabKitAnnieXTabFragmentV2.Companion;
            Boolean r11 = Boolean.valueOf(!r8);
            r10.getClass();
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitAnnieXTabFragmentV2 r12 = new TabKitAnnieXTabFragmentV2();
            Bundle r0 = new Bundle();
            Integer r6 = r7.n();
            if (r6 == null) goto L30;
            int r13 = r6.intValue();
        L31:
            r0.putInt("tab_id", r13);
            if (r11 == null) goto L34;
            r5 = r11.booleanValue();
        L34:
            r0.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r5);
            Unit r14 = Unit.INSTANCE;
            r12.setArguments(r0);
            r12.setLandingTab(r7.e);
            TabKitTabFragment r15 = r12;
        L62:
            return r15;
        L30:
            r13 = 0;
            goto L31
        L35:
            TabKitHybridTabFragmentV2.a r16 = TabKitHybridTabFragmentV2.Companion;
            Boolean r17 = Boolean.valueOf(!r8);
            r16.getClass();
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitHybridTabFragmentV2 r18 = new TabKitHybridTabFragmentV2();
            Bundle r19 = new Bundle();
            Integer r20 = r7.n();
            if (r20 == null) goto L38;
            int r21 = r20.intValue();
        L39:
            r19.putInt("tab_id", r21);
            if (r17 == null) goto L42;
            r5 = r17.booleanValue();
        L42:
            r19.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r5);
            Unit r22 = Unit.INSTANCE;
            r18.setArguments(r19);
            r18.setLandingTab(r7.e);
            r15 = r18;
            goto L62
        L38:
            r21 = 0;
            goto L39
        L43:
            TabKitAnnieXTabFragment.Companion.getClass();
            if (TabKitAnnieXTabFragment.a.a(r7, r9) == false) goto L53;
            Boolean r23 = Boolean.valueOf(!r8);
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitAnnieXTabFragment r24 = new TabKitAnnieXTabFragment();
            Bundle r25 = new Bundle();
            Integer r26 = r7.n();
            if (r26 == null) goto L48;
            int r27 = r26.intValue();
        L49:
            r25.putInt("tab_id", r27);
            if (r23 == null) goto L52;
            r5 = r23.booleanValue();
        L52:
            r25.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r5);
            Unit r28 = Unit.INSTANCE;
            r24.setArguments(r25);
            r24.setLandingTab(r7.e);
            r15 = r24;
            goto L62
        L48:
            r27 = 0;
            goto L49
        L53:
            TabKitHybridTabFragment.a r29 = TabKitHybridTabFragment.Companion;
            Boolean r30 = Boolean.valueOf(!r8);
            r29.getClass();
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitHybridTabFragment r31 = new TabKitHybridTabFragment();
            Bundle r32 = new Bundle();
            Integer r33 = r7.n();
            if (r33 == null) goto L56;
            int r34 = r33.intValue();
        L57:
            r32.putInt("tab_id", r34);
            if (r30 == null) goto L60;
            r5 = r30.booleanValue();
        L60:
            r32.putBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE, r5);
            Unit r35 = Unit.INSTANCE;
            r31.setArguments(r32);
            r31.setLandingTab(r7.e);
            r15 = r31;
            goto L62
        L56:
            r34 = 0;
            goto L57
        L10:
            if (r3.intValue() != 4) goto L23;
            int r36 = TabKitMixFrameTabFragment.j;
            Intrinsics.checkNotNullParameter(r7, "tab");
            TabKitMixFrameTabFragment r37 = new TabKitMixFrameTabFragment();
            Bundle r38 = new Bundle();
            r38.putSerializable("tab_id", r7.n());
            s r39 = r7.f();
            if (r39 == null) goto L16;
            com.bytedance.android.shopping.store.tabkit.model.a r40 = r39.a();
            if (r40 == null) goto L16;
            String r41 = r40.b();
        L17:
            r38.putSerializable("tab_api_url", r41);
            s r42 = r7.f();
            if (r42 == null) goto L22;
            com.bytedance.android.shopping.store.tabkit.model.a r43 = r42.a();
            if (r43 == null) goto L22;
            r2 = r43.a();
        L22:
            r38.putSerializable("tab_api_params", r2);
            Unit r44 = Unit.INSTANCE;
            r37.setArguments(r38);
            return r37;
        L16:
            r41 = null;
            goto L17
        L5:
            r3 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.TabKitViewModel$isRouterParamsInitialized$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(TabKitViewModel r7) {
            super(r7, TabKitViewModel.class, "routerParams", "getRouterParams()Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", 0);
        }

        public Object get() {
            return ((TabKitViewModel) ((CallableReference) this).receiver).getRouterParams();
        }

        public void set(Object r2) {
            ((TabKitViewModel) ((CallableReference) this).receiver).setRouterParams((TabKitRouterParams) r2);
        }
    }

    public final boolean getLandingFinishedOpt() {
        return ((Boolean) this.landingFinishedOpt$delegate.getValue()).booleanValue();
    }

    static {
        Companion = new a();
    }

    public final void clearFragments() {
        this.tabFragmentsMap.clear();
    }

    public final TabKitAbilityConfig getAbilityConfig() {
        TabKitAbilityConfig r0 = this.abilityConfig;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L5:
        return r0;
    }

    public final Integer getAnchorTabId() {
        z r0 = (z) this.tabResponse.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final boolean getCanShowSwipeIndicator() {
        Integer r0 = (Integer) this.screenState.getValue();
        if (r0 != null) goto L6;
    L16:
        return false;
    L6:
        if (r0.intValue() != 1) goto L16;
        TabKitRouterParams r1 = this.routerParams;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L10:
        Integer r2 = r1.getSplitIndicatorHidden();
        if (r2 != null) goto L14;
        return true;
    L14:
        if (r2.intValue() == 1) goto L16;
        return true;
    }

    public final TabKitTabFragment getCurrentSelectedFragment() {
        y r0 = (y) this.currentTab.getValue();
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = r0.a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return getTabFragment$default(this, r1, false, 2, null);
    L8:
        return null;
    }

    public final List<com.bytedance.android.shopping.store.tabkit.model.k> getHomeTabs() {
        z r0 = (z) this.tabResponse.getValue();
        if (r0 == null) goto L7;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.j();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    public final TabKitRouterParams getRouterParams() {
        TabKitRouterParams r0 = this.routerParams;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L5:
        return r0;
    }

    public final int getViewPagerTrulyPosition() {
        y r0 = (y) this.currentTab.getValue();
        if (r0 == null) goto L7;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = r0.a;
        if (r1 == null) goto L7;
        Integer r2 = r1.n();
    L9:
        return getTabTrulyIndex(r2);
    L7:
        r2 = null;
        goto L9
    }

    public final boolean isFullScreen() {
        Integer r0 = (Integer) this.screenState.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 0) goto L8;
        return true;
    }

    public final boolean isRouterParamsInitialized() {
        if (this.routerParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void notifyLandingFinished() {
        TabKitRouterParams r0 = this.routerParams;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r0.getAnchorUrl()) == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual((Boolean) this.isLandingFinished.getValue(), Boolean.FALSE) == false) goto L12;
        this.isLandingFinished.setValue(Boolean.TRUE);
        return;
    }

    public final void notifyLandingStart() {
        TabKitRouterParams r0 = this.routerParams;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r0.getAnchorUrl()) == true) goto L8;
        return;
    L8:
        if (this.isLandingFinished.getValue() != null) goto L12;
        this.isLandingFinished.setValue(Boolean.FALSE);
        return;
    }

    public final void notifyPageLandingFinished() {
        this.pageLandingFinished.setValue(Boolean.TRUE);
    }

    public final void removeMonitor() {
        Long r0 = this.tabKitMonitorId;
        if (r0 == null) goto L6;
        long r1 = r0.longValue();
        Map<Long, TabkitFirstFramePref> r2 = ok3.a.e;
        ok3.a.e.remove(Long.valueOf(r1));
        return;
    }

    public TabKitViewModel() {
        this.screenState = new MutableLiveData();
        this.tabResponse = new MutableLiveData();
        this.interceptorHelper = new h();
        this.kvStorage = new i(this);
        this.screenOffsetFactor = new MutableLiveData();
        this.screenOffset = new MutableLiveData();
        this.loadStatus = new MutableLiveData();
        this.eventContext = new TabKitEventContext(this);
        this.currentHomeTab = new MutableLiveData();
        this.currentTab = new MutableLiveData();
        this.currentTabAfter = new MutableLiveData();
        this.foldScreenSize = new MutableLiveData();
        this.lynxCards = new ArrayList();
        this.hybridComponents = new ArrayList();
        this.jsEventStub = new com.bytedance.android.shopping.store.tabkit.bridge.c(this);
        this.jsBridge = new TabKitBridge(this);
        this.recordedEventsMap = new HashMap();
        this.navBarVisibilityMap = new HashMap();
        this.topTabBarVisibilityMap = new HashMap();
        this.firstSetData = true;
        this.isUseNativeTopBar = new MutableLiveData();
        this.isUseNativeBottomBar = new MutableLiveData();
        this.isLandingFinished = new MutableLiveData();
        this.pageLandingFinished = new MutableLiveData(Boolean.FALSE);
        this.landingFinishedOpt$delegate = LazyKt.lazy(TabKitViewModel$landingFinishedOpt$2.INSTANCE);
        this.tabSwitchMode = new MutableLiveData();
        this.tabsContainerId = UUID.randomUUID().toString();
        this.tabKitComponentFactory = new b();
        this.tabFragmentsMap = new SparseArray();
        this.dialogsMap = new HashMap();
        this.tabKitLifeListeners = new ArrayList();
        this.tabStates = new ConcurrentHashMap();
    }

    private final com.bytedance.android.shopping.store.tabkit.model.k getDefaultAnchorTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.firstOrNull(getHomeTabs());
        if (r0 == null) goto L9;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.m();
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.getOrNull(r1, 0);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return (com.bytedance.android.shopping.store.tabkit.model.k) CollectionsKt.firstOrNull(getHomeTabs());
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getAnchorHomeTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getAnchorTab();
        if (r0 != null) goto L5;
    L10:
        com.bytedance.android.shopping.store.tabkit.model.k r1 = getAnchorTab();
        if (r1 != null) goto L16;
        return null;
    L16:
        return r1.a;
    L5:
        if (r0.a != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L10;
        return getAnchorTab();
    L7:
        r2 = false;
        goto L8
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getAnchorTab() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTargetAnchorTab();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getDefaultAnchorTab();
    }

    public final r getTabDowngradeConfig() {
        Integer r0 = getAnchorTabId();
        if (r0 == null) goto L12;
        String r1 = String.valueOf(r0.intValue());
        if (r1 == null) goto L13;
        z r2 = (z) this.tabResponse.getValue();
        if (r2 == null) goto L14;
        Map<String, r> r3 = r2.i();
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.get(r1);
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTargetAnchorTab() {
        return getTabById(getAnchorTabId());
    }

    public final boolean getClickCloseBtn() {
        return this.clickCloseBtn;
    }

    public final MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> getCurrentHomeTab() {
        return this.currentHomeTab;
    }

    public final MutableLiveData<y> getCurrentTab() {
        return this.currentTab;
    }

    public final MutableLiveData<y> getCurrentTabAfter() {
        return this.currentTabAfter;
    }

    public final HashMap<String, ArrayList<TabKitDialogView>> getDialogsMap() {
        return this.dialogsMap;
    }

    public final TabKitEventContext getEventContext() {
        return this.eventContext;
    }

    public final boolean getFirstSetData() {
        return this.firstSetData;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getFoldScreenSize() {
        return this.foldScreenSize;
    }

    public final String getFoldType() {
        return this.foldType;
    }

    public final ArrayList<ti.l> getHybridComponents() {
        return this.hybridComponents;
    }

    public final h getInterceptorHelper() {
        return this.interceptorHelper;
    }

    public final TabKitBridge getJsBridge() {
        return this.jsBridge;
    }

    public final com.bytedance.android.shopping.store.tabkit.bridge.c getJsEventStub() {
        return this.jsEventStub;
    }

    public final i getKvStorage() {
        return this.kvStorage;
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getLastTab() {
        return this.lastTab;
    }

    public final Long getLastTimeStamp() {
        return this.lastTimeStamp;
    }

    public final MutableLiveData<Integer> getLoadStatus() {
        return this.loadStatus;
    }

    public final ArrayList<ECLynxCard> getLynxCards() {
        return this.lynxCards;
    }

    public final String getMarketingPageId() {
        return this.marketingPageId;
    }

    public final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, Boolean> getNavBarVisibilityMap() {
        return this.navBarVisibilityMap;
    }

    public final boolean getNoRadius() {
        return this.noRadius;
    }

    public final MutableLiveData<Boolean> getPageLandingFinished() {
        return this.pageLandingFinished;
    }

    public final HashMap<String, Boolean> getRecordedEventsMap() {
        return this.recordedEventsMap;
    }

    public final MutableLiveData<Pair<Float, Float>> getScreenOffset() {
        return this.screenOffset;
    }

    public final MutableLiveData<Float> getScreenOffsetFactor() {
        return this.screenOffsetFactor;
    }

    public final MutableLiveData<Integer> getScreenState() {
        return this.screenState;
    }

    public final ITabKitComponentFactory getTabKitComponentFactory() {
        return this.tabKitComponentFactory;
    }

    public final ArrayList<g> getTabKitLifeListeners() {
        return this.tabKitLifeListeners;
    }

    public final ok3.a getTabKitMonitor() {
        return this.tabKitMonitor;
    }

    public final Long getTabKitMonitorId() {
        return this.tabKitMonitorId;
    }

    public final MutableLiveData<z> getTabResponse() {
        return this.tabResponse;
    }

    public final MutableLiveData<Integer> getTabSwitchMode() {
        return this.tabSwitchMode;
    }

    public final TabkitPrefetchJobKey getTabkitPrefetchJobKey() {
        return this.tabkitPrefetchJobKey;
    }

    public final String getTabsContainerId() {
        return this.tabsContainerId;
    }

    public final HashMap<com.bytedance.android.shopping.store.tabkit.model.k, com.bytedance.android.shopping.store.tabkit.model.d> getTopTabBarVisibilityMap() {
        return this.topTabBarVisibilityMap;
    }

    public final boolean isAnchorFinished() {
        return this.isAnchorFinished;
    }

    public final boolean isFoldPage() {
        return this.isFoldPage;
    }

    public final MutableLiveData<Boolean> isLandingFinished() {
        return this.isLandingFinished;
    }

    public final boolean isLitePage() {
        return this.isLitePage;
    }

    public final MutableLiveData<Boolean> isUseNativeBottomBar() {
        return this.isUseNativeBottomBar;
    }

    public final MutableLiveData<Boolean> isUseNativeTopBar() {
        return this.isUseNativeTopBar;
    }

    private final void filterErrorTabFragment(z r9) {
        int r0 = this.tabFragmentsMap.size();
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L24;
        int r3 = this.tabFragmentsMap.keyAt(r2);
        com.bytedance.android.shopping.store.tabkit.model.k r4 = getTabById(Integer.valueOf(this.tabFragmentsMap.get(r3).getTabId()));
        if (r4 == null) goto L23;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r5 = r9.j();
        if (r5 == null) goto L23;
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L23;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = (com.bytedance.android.shopping.store.tabkit.model.k) r6.next();
        if (checkTabValid(r7, r4) == true) goto L15;
        r1.add(Integer.valueOf(r3));
    L15:
        List<com.bytedance.android.shopping.store.tabkit.model.k> r8 = r7.m();
        if (r8 == null) goto L11;
        Iterator<T> r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L11;
        if (checkTabValid((com.bytedance.android.shopping.store.tabkit.model.k) r10.next(), r4) == true) goto L19;
        r1.add(Integer.valueOf(r3));
    L23:
        r2 = r2 + 1;
        goto L3
    L24:
        Iterator r11 = r1.iterator();
    L26:
        if (r11.hasNext() == false) goto L28;
        int r12 = ((Number) r11.next()).intValue();
        this.tabFragmentsMap.remove(r12);
        goto L26
    }

    private final void initMonitor(Bundle r4) {
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
    L7:
        if ((r5 instanceof Long) == true) goto L9;
        r5 = null;
    L9:
        Long r6 = (Long) r5;
        if (r6 == null) goto L18;
        long r1 = r6.longValue();
        this.tabKitMonitorId = Long.valueOf(r1);
        Map<Long, TabkitFirstFramePref> r7 = ok3.a.e;
        TabkitFirstFramePref r8 = ok3.a.C0149a.a(r1);
        if (r8 == null) goto L20;
        ok3.a r2 = new ok3.a(this, r8);
        this.tabKitMonitor = r2;
        TabkitFirstFramePref r9 = r2.d;
        if (r9 == null) goto L19;
        TabkitFramePref.recordTime$default(r9, TabkitFirstFramePref.T_PAGE_INIT_END, null, 2, null);
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r5 = null;
        goto L7
    }

    private final void initPrefetchJobKey(Bundle r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        Serializable r4 = r3.getSerializable("tabkit_prefetch");
    L7:
        if ((r4 instanceof TabkitPrefetchJobKey) == false) goto L10;
        r0 = r4;
    L10:
        this.tabkitPrefetchJobKey = (TabkitPrefetchJobKey) r0;
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void addTabKitLifeListener(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.tabKitLifeListeners.add(r2);
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTabById(Integer r6) {
        z r0 = (z) this.tabResponse.getValue();
        if (r0 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.j();
    L6:
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L21;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = (com.bytedance.android.shopping.store.tabkit.model.k) r2.next();
        if (Intrinsics.areEqual(r3.n(), r6) == true) goto L12;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r4 = r3.m();
        if (r4 == null) goto L9;
        Iterator<T> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = (com.bytedance.android.shopping.store.tabkit.model.k) r5.next();
        if (Intrinsics.areEqual(r7.n(), r6) == false) goto L17;
        return r7;
    L12:
        return r3;
    L21:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final Pair<Integer, Integer> getTabIndex(com.bytedance.android.shopping.store.tabkit.model.k r9) {
        Intrinsics.checkNotNullParameter(r9, "tab");
        z r0 = (z) this.tabResponse.getValue();
        if (r0 == null) goto L30;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.j();
        if (r1 == null) goto L30;
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L30;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        com.bytedance.android.shopping.store.tabkit.model.k r6 = (com.bytedance.android.shopping.store.tabkit.model.k) r4;
        if (Intrinsics.areEqual(r6, r9) == true) goto L15;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r7 = r6.m();
        if (r7 == null) goto L29;
        Iterator<T> r8 = r7.iterator();
        int r10 = 0;
    L20:
        if (r8.hasNext() == false) goto L29;
        Object r11 = r8.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        if (Intrinsics.areEqual((com.bytedance.android.shopping.store.tabkit.model.k) r11, r9) == true) goto L27;
        r10 = r12;
        goto L20
    L27:
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r10));
    L29:
        r3 = r5;
        goto L8
    L15:
        return new Pair(Integer.valueOf(r3), 0);
    L30:
        Intrinsics.checkNotNull(null);
        return null;
    }

    public final v getTabState(Integer r3) {
        if (r3 == null) goto L11;
        r3.intValue();
        ConcurrentHashMap<Integer, v> r0 = this.tabStates;
        v r1 = r0.get(r3);
        if (r1 != null) goto L10;
        r1 = new v();
        v r4 = r0.putIfAbsent(r3, r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        return r1;
    L11:
        return null;
    }

    public final int getTabTrulyIndex(Integer r5) {
        z r0 = (z) this.tabResponse.getValue();
        if (r0 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.j();
    L6:
        int r2 = 0;
        if (r1 == null) goto L27;
        Iterator<T> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L27;
        com.bytedance.android.shopping.store.tabkit.model.k r4 = (com.bytedance.android.shopping.store.tabkit.model.k) r3.next();
        if (r4.g() == false) goto L14;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r6 = r4.m();
        if (r6 == null) goto L10;
        Iterator<T> r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.store.tabkit.model.k) r7.next()).n(), r5) == true) goto L24;
        r2 = r2 + 1;
        goto L21
    L24:
        return r2;
    L14:
        if (Intrinsics.areEqual(r4.n(), r5) == true) goto L15;
        r2 = r2 + 1;
        goto L10
    L15:
        return r2;
    L27:
        return r2 + 1;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.shopping.store.tabkit.model.k getTrulyTabByPosition(Integer r7) {
        z r0 = (z) this.tabResponse.getValue();
        if (r0 == null) goto L5;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r1 = r0.j();
    L6:
        if (r1 == null) goto L30;
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L30;
        com.bytedance.android.shopping.store.tabkit.model.k r4 = (com.bytedance.android.shopping.store.tabkit.model.k) r2.next();
        if (r4.g() == false) goto L12;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r5 = r4.m();
        if (r5 == null) goto L9;
        Iterator<T> r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r8 = (com.bytedance.android.shopping.store.tabkit.model.k) r6.next();
        if (r7 == null) goto L29;
        if (r3 != r7.intValue()) goto L29;
        return r8;
    L29:
        r3 = r3 + 1;
        goto L22
    L12:
        if (r7 != null) goto L15;
    L17:
        r3 = r3 + 1;
        goto L9
    L15:
        if (r3 != r7.intValue()) goto L17;
        return r4;
    L30:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final void init(Bundle r4) {
        initMonitor(r4);
        TabKitRouterParams r1 = this.routerParams;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L5:
        this.abilityConfig = new TabKitAbilityConfig(r1);
        initPrefetchJobKey(r4);
    }

    public final boolean isTabAlreadyShow(Integer r3) {
        com.bytedance.android.shopping.store.tabkit.model.k r4 = getTabById(r3);
        Boolean r0 = null;
        if (r4 == null) goto L8;
        TabKitTabFragment r5 = getTabFragment(r4, false);
        if (r5 == null) goto L8;
        r0 = Boolean.valueOf(r5.isAlreadyShow());
    L8:
        return Intrinsics.areEqual(r0, Boolean.TRUE);
    }

    public final void prepare(Bundle r4) {
        Serializable r0 = null;
        if (r4 == null) goto L5;
        Serializable r1 = r4.getSerializable(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L7:
        if ((r1 instanceof TabKitRouterParams) == false) goto L10;
        r0 = r1;
    L10:
        TabKitRouterParams r2 = (TabKitRouterParams) r0;
        if (r2 != null) goto L13;
        r2 = new TabKitRouterParams();
    L13:
        this.routerParams = r2;
        boolean r3 = false;
        if (r4 == null) goto L16;
        r3 = r4.getBoolean("tabkit_lite_page", false);
    L16:
        this.isLitePage = r3;
        if (r4 == null) goto L24;
        String r5 = r4.getString("tabkit_fold_type");
        if (r5 == null) goto L25;
        String r6 = a2.c(r5);
        if (r6 == null) goto L26;
        this.foldType = r6;
        this.isFoldPage = true;
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setAbilityConfig(TabKitAbilityConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.abilityConfig = r2;
    }

    public final void setAnchorFinished(boolean r1) {
        this.isAnchorFinished = r1;
    }

    public final void setClickCloseBtn(boolean r1) {
        this.clickCloseBtn = r1;
    }

    public final void setFirstSetData(boolean r1) {
        this.firstSetData = r1;
    }

    public final void setFoldPage(boolean r1) {
        this.isFoldPage = r1;
    }

    public final void setFoldType(String r1) {
        this.foldType = r1;
    }

    public final void setLastTab(com.bytedance.android.shopping.store.tabkit.model.k r1) {
        this.lastTab = r1;
    }

    public final void setLastTimeStamp(Long r1) {
        this.lastTimeStamp = r1;
    }

    public final void setLitePage(boolean r1) {
        this.isLitePage = r1;
    }

    public final void setMarketingPageId(String r1) {
        this.marketingPageId = r1;
    }

    public final void setNoRadius(boolean r1) {
        this.noRadius = r1;
    }

    public final void setRouterParams(TabKitRouterParams r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.routerParams = r2;
    }

    public final void setTabKitComponentFactory(ITabKitComponentFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabKitComponentFactory = r2;
    }

    public final void setTabKitData(z r6) {
        Intrinsics.checkNotNullParameter(r6, "tabsResponse");
        Map<String, String> r0 = r6.e();     // Catch: Exception -> L13
        if (r0 == null) goto L7;
        this.eventContext.getExtraParams().putAll(r0);     // Catch: Exception -> L13
    L7:
        if (r6.a == true) goto L9;
        t.g(r6, this, true);     // Catch: Exception -> L13
    L9:
        this.loadStatus.setValue(1);     // Catch: Exception -> L13
        filterErrorTabFragment(r6);     // Catch: Exception -> L13
        this.tabResponse.setValue(r6);     // Catch: Exception -> L13
        cl.d.a.getClass();     // Catch: Exception -> L13
        cl.d r7 = cl.d.a.b();     // Catch: Exception -> L13
        if (r7 == null) goto L17;
        r7.n();     // Catch: Exception -> L13
        return;
    L17:
        return;
    L13:
        e = move-exception;
        dm.a.a("ECTabKitDebug").i("setTabKitData error " + e);
        StackTraceElement[] r8 = e.getStackTrace();
        int r1 = r8.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L22;
        dm.a.a("ECTabKitDebug").i(String.valueOf(r8[r2]));
        r2 = r2 + 1;
        goto L15
    }

    public final void setTabKitMonitor(ok3.a r1) {
        this.tabKitMonitor = r1;
    }

    public final void setTabkitPrefetchJobKey(TabkitPrefetchJobKey r1) {
        this.tabkitPrefetchJobKey = r1;
    }

    private final boolean checkTabValid(com.bytedance.android.shopping.store.tabkit.model.k r9, com.bytedance.android.shopping.store.tabkit.model.k r10) {
        if (Intrinsics.areEqual(r9.n(), r10.n()) == false) goto L79;
        s r0 = r9.f();
        Integer r2 = null;
        if (r0 == null) goto L9;
        String r1 = r0.b();
        if (r1 == null) goto L9;
        Uri r3 = UriProtector.parse(r1);
    L10:
        s r4 = r10.f();
        if (r4 == null) goto L15;
        String r5 = r4.b();
        if (r5 == null) goto L15;
        Uri r6 = UriProtector.parse(r5);
    L16:
        int r7 = hk3.a.a;
        int r8 = p.a;
        Object r11 = Boolean.FALSE;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L21
        Object r14 = jj4.a.a("tabkit_check_tab_valid_opt", Boolean.class, r11, false);     // Catch: Throwable -> L21
        if (r14 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L21
    L28:
        if (((Boolean) r14).booleanValue() == false) goto L57;
        if (r3 == null) goto L31;
        String r15 = r3.getPath();
    L32:
        if (r6 == null) goto L34;
        String r16 = r6.getPath();
    L36:
        if (Intrinsics.areEqual(r15, r16) == false) goto L75;
        s r17 = r9.f();
        if (r17 == null) goto L40;
        Integer r18 = r17.c();
    L41:
        s r19 = r10.f();
        if (r19 == null) goto L44;
        Integer r20 = r19.c();
    L46:
        if (Intrinsics.areEqual(r18, r20) == false) goto L75;
        s r21 = r9.f();
        if (r21 == null) goto L50;
        Integer r22 = r21.d();
    L51:
        s r110 = r10.f();
        if (r110 == null) goto L55;
        r2 = r110.d();
    L55:
        if (Intrinsics.areEqual(r22, r2) == false) goto L75;
        return true;
    L50:
        r22 = null;
        goto L51
    L44:
        r20 = null;
        goto L46
    L40:
        r18 = null;
    L75:
        return false;
    L34:
        r16 = null;
        goto L36
    L31:
        r15 = null;
        goto L32
    L57:
        if (r3 == null) goto L59;
        String r23 = r3.getPath();
    L60:
        if (r6 == null) goto L62;
        String r24 = r6.getPath();
    L64:
        if (Intrinsics.areEqual(r23, r24) == false) goto L75;
        s r25 = r9.f();
        if (r25 == null) goto L68;
        Integer r26 = r25.c();
    L69:
        s r111 = r10.f();
        if (r111 == null) goto L73;
        r2 = r111.c();
    L73:
        if (Intrinsics.areEqual(r26, r2) == false) goto L75;
        return true;
    L68:
        r26 = null;
        goto L69
    L62:
        r24 = null;
        goto L64
    L59:
        r23 = null;
    L21:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Object r28 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r28) == true) goto L26;
        r11 = r28;
    L26:
        r14 = r11;
    L15:
        r6 = null;
    L9:
        r3 = null;
        goto L10
    L79:
        return true;
    }

    public final String buildBundleUrlWithRouterParams(String r6, boolean r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        a r0 = Companion;
        TabKitRouterParams r1 = this.routerParams;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("routerParams");
    L8:
        TabKitAbilityConfig r2 = this.abilityConfig;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L11:
        boolean r3 = r2.b("na_prefetch_sync_update");
        TabKitAbilityConfig r4 = this.abilityConfig;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L14:
        boolean r5 = r4.b("btm_custom_page_v2");
        r0.getClass();
        return a.a(r6, r1, r7, r3, r5);
    }

    public final TabKitTabFragment getTabFragment(com.bytedance.android.shopping.store.tabkit.model.k r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "tab");
        Integer r0 = r5.n();
        TabKitTabFragment r1 = null;
        if (r0 == null) goto L20;
        int r2 = r0.intValue();
        TabKitTabFragment r3 = this.tabFragmentsMap.get(r2);
        if (r3 != null) goto L21;
        if (r6 == false) goto L19;
        int r4 = 0;
        if (r5.a == null) goto L10;
        boolean r7 = true;
    L11:
        ITabKitComponentFactory r8 = this.tabKitComponentFactory;
        TabKitAbilityConfig r9 = this.abilityConfig;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("abilityConfig");
    L14:
        r1 = r8.createTab(r5, r7, r9);
        SparseArray<TabKitTabFragment> r10 = this.tabFragmentsMap;
        Integer r11 = r5.n();
        if (r11 == null) goto L17;
        r4 = r11.intValue();
    L17:
        r10.put(r4, r1);
        goto L19
    L10:
        r7 = false;
    L19:
        return r1;
    L21:
        return r3;
    L20:
        return null;
    }

    public static /* synthetic */ String buildBundleUrlWithRouterParams$default(TabKitViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.buildBundleUrlWithRouterParams(r1, r2);
    }

    public static /* synthetic */ TabKitTabFragment getTabFragment$default(TabKitViewModel r0, com.bytedance.android.shopping.store.tabkit.model.k r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.getTabFragment(r1, r2);
    }
}

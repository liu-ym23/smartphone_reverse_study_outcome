package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bb\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\nH\u0016J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J,\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\u001e\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000402H\u0016J\u0016\u00105\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000402H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\u0011\u00107\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b7\u00108J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b9\u00108J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\u0011\u0010=\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b=\u00108J\u0011\u0010>\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b>\u0010?J\b\u0010A\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020E2\u0006\u0010\u000f\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020GH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\u0018H\u0016J\u001e\u0010M\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020L02H\u0016J\u0016\u0010N\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020L02H\u0016R\u0017\u0010P\u001a\u00020O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR(\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR(\u0010l\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010d\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010q\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010d\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR(\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010d\u001a\u0004\bu\u0010n\"\u0004\bv\u0010pR(\u0010w\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010d\u001a\u0004\bx\u0010n\"\u0004\by\u0010pR(\u0010z\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010d\u001a\u0004\b{\u0010n\"\u0004\b|\u0010pR$\u0010}\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0014\n\u0004\b}\u0010~\u001a\u0004\b}\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010~\u001a\u0005\b\u0082\u0001\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010\u0089\u0001\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u0010\u007fR+\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R+\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u008b\u0001\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u008b\u0001\u001a\u0006\b\u0094\u0001\u0010\u008d\u0001\"\u0006\b\u0095\u0001\u0010\u008f\u0001R+\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u008b\u0001\u001a\u0006\b\u0097\u0001\u0010\u008d\u0001\"\u0006\b\u0098\u0001\u0010\u008f\u0001R+\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u008b\u0001\u001a\u0006\b\u009a\u0001\u0010\u008d\u0001\"\u0006\b\u009b\u0001\u0010\u008f\u0001R+\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u008b\u0001\u001a\u0006\b\u009d\u0001\u0010\u008d\u0001\"\u0006\b\u009e\u0001\u0010\u008f\u0001R+\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010\u008b\u0001\u001a\u0006\b \u0001\u0010\u008d\u0001\"\u0006\b¡\u0001\u0010\u008f\u0001R+\u0010¢\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010\u008b\u0001\u001a\u0006\b£\u0001\u0010\u008d\u0001\"\u0006\b¤\u0001\u0010\u008f\u0001R+\u0010¥\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010\u008b\u0001\u001a\u0006\b¦\u0001\u0010\u008d\u0001\"\u0006\b§\u0001\u0010\u008f\u0001R+\u0010¨\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010\u008b\u0001\u001a\u0006\b©\u0001\u0010\u008d\u0001\"\u0006\bª\u0001\u0010\u008f\u0001R+\u0010«\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010\u008b\u0001\u001a\u0006\b¬\u0001\u0010\u008d\u0001\"\u0006\b\u00ad\u0001\u0010\u008f\u0001R'\u0010®\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b®\u0001\u0010~\u001a\u0005\b¯\u0001\u0010\u007f\"\u0006\b°\u0001\u0010\u0081\u0001R)\u0010±\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R)\u0010·\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010²\u0001\u001a\u0006\b¸\u0001\u0010´\u0001\"\u0006\b¹\u0001\u0010¶\u0001R'\u0010º\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\bº\u0001\u0010~\u001a\u0005\b»\u0001\u0010\u007f\"\u0006\b¼\u0001\u0010\u0081\u0001R+\u0010½\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010\u008b\u0001\u001a\u0006\b¾\u0001\u0010\u008d\u0001\"\u0006\b¿\u0001\u0010\u008f\u0001R'\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u001b\u0010\u008b\u0001\u001a\u0006\bÀ\u0001\u0010\u008d\u0001\"\u0006\bÁ\u0001\u0010\u008f\u0001R+\u0010Â\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010\u008b\u0001\u001a\u0006\bÃ\u0001\u0010\u008d\u0001\"\u0006\bÄ\u0001\u0010\u008f\u0001R+\u0010Å\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u008b\u0001\u001a\u0006\bÆ\u0001\u0010\u008d\u0001\"\u0006\bÇ\u0001\u0010\u008f\u0001R1\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R2\u0010Ð\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ë\u0001\u001a\u0006\bÑ\u0001\u0010Í\u0001\"\u0006\bÒ\u0001\u0010Ï\u0001R5\u0010Ô\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010Ó\u0001\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Ë\u0001\u001a\u0006\bÕ\u0001\u0010Í\u0001\"\u0006\bÖ\u0001\u0010Ï\u0001R2\u0010×\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ë\u0001\u001a\u0006\bØ\u0001\u0010Í\u0001\"\u0006\bÙ\u0001\u0010Ï\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/o;", "", "v", "", "updateHomeContainerSelectedIndex", "", "isInFeedPage", "Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "config", "initPageConfig", "getPageConfig", "", "data", "oldData", "startIndex", "", "filterRefreshData", "filterMoreData", "forwardData", "filterForwardData", "onCleared", "", "getCurrentPosition", "", "sceneId", "state", "setCommentShowState", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper$c;", "listener", "removePlayDurationChangeListener", "addPlayDurationChangeListener", "Lcom/bytedance/awemeopen/infra/base/player/k;", "statusListener", "addPlayStateListener", "removePlayStateListener", "getWatchDuration", "getDuration", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/d;", "getISeekBar", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/d$a;", "addSeekBarChangeListener", "removeSeekBarChangeListener", "playerIsPlaying", "playPlayer", "markDislike", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "observeCommentShowState", "removeObserveCommentShowState", "getHasPlayCount", "getAutoPlayState", "()Ljava/lang/Boolean;", "showAutoPlaySwitch", "turnOnAutoPlaySwitch", "turnOffAutoPlaySwitch", "doAutoPlay", "canAutoPlay", "timeOnLiveRoom", "()Ljava/lang/Long;", "Lcom/bytedance/awemeopen/infra/base/player/g;", "getPlayer", "Lp54/b;", "getPlayerController", "Lr14/c;", "Lcom/bytedance/awemeopen/infra/base/player/j;", "toPlayRequest", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper$c;", "setVideoAutoPlayListener", "removeVideoAutoPlayListener", "ignorePageStatusControl", "fullscreenButtonDelayMs", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper$b;", "addPauseOrPlayObserver", "removePauseOrPlayObserver", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "feedPlayerHelper", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "getFeedPlayerHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "autoPlayHelper", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "getAutoPlayHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "setAutoPlayHelper", "(Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;)V", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "feedSeekBarHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "getFeedSeekBarHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "setFeedSeekBarHelper", "(Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;)V", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "_feedHomeContainerSelectedIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "Landroidx/lifecycle/LiveData;", "feedHomeContainerSelectedIndex", "Landroidx/lifecycle/LiveData;", "getFeedHomeContainerSelectedIndex", "()Landroidx/lifecycle/LiveData;", "setFeedHomeContainerSelectedIndex", "(Landroidx/lifecycle/LiveData;)V", "feedHomeContainerDeliverHiddenState", "getFeedHomeContainerDeliverHiddenState", "()Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "setFeedHomeContainerDeliverHiddenState", "(Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;)V", "enterCleanMode", "getEnterCleanMode", "setEnterCleanMode", "enterPinchMode", "getEnterPinchMode", "setEnterPinchMode", "loadMoreUiShow", "getLoadMoreUiShow", "setLoadMoreUiShow", "enterSkeleton", "getEnterSkeleton", "setEnterSkeleton", "isFeedVisible", "Z", "()Z", "setFeedVisible", "(Z)V", "isRefreshing", "setRefreshing", "feedPageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "enableBtmComment$delegate", "Lkotlin/Lazy;", "getEnableBtmComment", "enableBtmComment", "waitToConsumeEnterAid", "Ljava/lang/String;", "getWaitToConsumeEnterAid", "()Ljava/lang/String;", "setWaitToConsumeEnterAid", "(Ljava/lang/String;)V", "waitToConsumeEnterRequestId", "getWaitToConsumeEnterRequestId", "setWaitToConsumeEnterRequestId", "waitToConsumeEnterGid", "getWaitToConsumeEnterGid", "setWaitToConsumeEnterGid", "waitToConsumeEnterAids", "getWaitToConsumeEnterAids", "setWaitToConsumeEnterAids", "waitToConsumeEnterGids", "getWaitToConsumeEnterGids", "setWaitToConsumeEnterGids", "waitToConsumeEnterLocalParams", "getWaitToConsumeEnterLocalParams", "setWaitToConsumeEnterLocalParams", "waitToConsumeEnterClientParams", "getWaitToConsumeEnterClientParams", "setWaitToConsumeEnterClientParams", "waitToConsumeEnterHostVideoSequence", "getWaitToConsumeEnterHostVideoSequence", "setWaitToConsumeEnterHostVideoSequence", "contentScene", "getContentScene", "setContentScene", "startType", "getStartType", "setStartType", "overType", "getOverType", "setOverType", "enableFollowChannel", "getEnableFollowChannel", "setEnableFollowChannel", "playTimeDurationRecord", "J", "getPlayTimeDurationRecord", "()J", "setPlayTimeDurationRecord", "(J)V", "postPlayTimeDurationRecord", "getPostPlayTimeDurationRecord", "setPostPlayTimeDurationRecord", "needDouyinFlag", "getNeedDouyinFlag", "setNeedDouyinFlag", "contenScene", "getContenScene", "setContenScene", "getSceneId", "setSceneId", "waitToConsumeEnterLiveRoomId", "getWaitToConsumeEnterLiveRoomId", "setWaitToConsumeEnterLiveRoomId", "commerceClickType", "getCommerceClickType", "setCommerceClickType", "Landroidx/lifecycle/MutableLiveData;", "Lpz3/d;", "videoScaling", "Landroidx/lifecycle/MutableLiveData;", "getVideoScaling", "()Landroidx/lifecycle/MutableLiveData;", "setVideoScaling", "(Landroidx/lifecycle/MutableLiveData;)V", "slidesProgressPosition", "getSlidesProgressPosition", "setSlidesProgressPosition", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/p;", "slidesProgressInfo", "getSlidesProgressInfo", "setSlidesProgressInfo", "slidesPlayCompletedPosition", "getSlidesPlayCompletedPosition", "setSlidesPlayCompletedPosition", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class FeedPagerListViewModel extends AosPagerListViewModel<jz3.a> implements o {
    private DiscardFirstValueLiveData<Integer> _feedHomeContainerSelectedIndex;
    private AutoPlayHelper autoPlayHelper;
    private String commerceClickType;
    private String contenScene;
    private String contentScene;
    private final Lazy enableBtmComment$delegate;
    private boolean enableFollowChannel;
    private DiscardFirstValueLiveData<Boolean> enterCleanMode;
    private DiscardFirstValueLiveData<Boolean> enterPinchMode;
    private DiscardFirstValueLiveData<Boolean> enterSkeleton;
    private DiscardFirstValueLiveData<Boolean> feedHomeContainerDeliverHiddenState;
    private LiveData<Integer> feedHomeContainerSelectedIndex;
    private FeedPageConfig feedPageConfig;
    private final FeedPlayerHelper feedPlayerHelper;
    private FeedSeekBarHelper feedSeekBarHelper;
    private boolean isFeedVisible;
    private boolean isRefreshing;
    private DiscardFirstValueLiveData<Boolean> loadMoreUiShow;
    private boolean needDouyinFlag;
    private String overType;
    private long playTimeDurationRecord;
    private long postPlayTimeDurationRecord;
    private String sceneId;
    private MutableLiveData<Integer> slidesPlayCompletedPosition;
    private MutableLiveData<p> slidesProgressInfo;
    private MutableLiveData<Integer> slidesProgressPosition;
    private String startType;
    private MutableLiveData<pz3.d> videoScaling;
    private String waitToConsumeEnterAid;
    private String waitToConsumeEnterAids;
    private String waitToConsumeEnterClientParams;
    private String waitToConsumeEnterGid;
    private String waitToConsumeEnterGids;
    private String waitToConsumeEnterHostVideoSequence;
    private String waitToConsumeEnterLiveRoomId;
    private String waitToConsumeEnterLocalParams;
    private String waitToConsumeEnterRequestId;

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean forceEnableShareInCardMode() {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Map<String, String> getHostExtraInfo() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public l54.b getUIConfig() {
        return null;
    }

    public void setHostExtraInfo(Map<String, String> r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean canAutoPlay() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.a());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void doAutoPlay() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a() == false) goto L34;
        int r1 = r0.a.getCurrentIndex();
        ListState r2 = (ListState) r0.a.getDataList().getValue();
        r14.c r3 = null;
        if (r2 == null) goto L12;
        List r4 = (List) r2.a;
        if (r4 == null) goto L12;
        jz3.a r5 = (jz3.a) CollectionsKt.getOrNull(r4, r1);
    L13:
        ListState r6 = (ListState) r0.a.getDataList().getValue();
        if (r6 == null) goto L18;
        List r7 = (List) r6.a;
        if (r7 == null) goto L18;
        jz3.a r8 = (jz3.a) CollectionsKt.getOrNull(r7, r1 + 1);
    L20:
        if (r8 != null) goto L23;
        AoLogger.b("AutoPlayHelper", new Object[]{"feedItem is null"});
        return;
    L23:
        if (r0.d == false) goto L25;
        r0.d = false;
    L30:
        r8.a.t = true;
        r0.e.setValue(Integer.valueOf(r1 + 1));
        return;
    L25:
        if (r5 == null) goto L27;
        r3 = r5.a;
    L27:
        if (r3 == null) goto L30;
        r3.t = true;
    L18:
        r8 = null;
    L12:
        r5 = null;
        goto L13
    }

    public long fullscreenButtonDelayMs() {
        FeedPageConfig r0 = this.feedPageConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r0 = null;
    L6:
        return r0.getFullscreenButtonAppearDelayMs();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean getAutoPlayState() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.b.getAutoPlayState());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public long getCurrentPosition() {
        return this.feedPlayerHelper.e().getCurrentPosition();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public long getDuration() {
        return this.feedPlayerHelper.e().getDuration();
    }

    public final boolean getEnableBtmComment() {
        return ((Boolean) this.enableBtmComment$delegate.getValue()).booleanValue();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public FeedPageConfig getPageConfig() {
        FeedPageConfig r0 = this.feedPageConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public com.bytedance.awemeopen.infra.base.player.g getPlayer() {
        return this.feedPlayerHelper.e();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public long getWatchDuration() {
        return this.feedPlayerHelper.e().getWatchDuration();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean ignorePageStatusControl() {
        return this.feedPlayerHelper.e;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean isInFeedPage() {
        Integer r0 = (Integer) this._feedHomeContainerSelectedIndex.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 0) goto L8;
        return true;
    }

    public void onCleared() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        FeedPlayerHelper r1 = this.feedPlayerHelper;
        r1.getClass();
        FeedPlayerHelper.d();
        r1.b.clear();
        this.feedPlayerHelper.e().k(null);
        this.feedPlayerHelper.e().release();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void playPlayer() {
        this.feedPlayerHelper.playPlayer();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean playerIsPlaying() {
        return this.feedPlayerHelper.playerIsPlaying();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removeVideoAutoPlayListener() {
        this.feedPlayerHelper.d = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean showAutoPlaySwitch() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 == null) goto L5;
        r0.b.showAutoPlaySwitch();
        return Boolean.TRUE;
    L5:
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Long timeOnLiveRoom() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.b.timeOnLiveRoom());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void turnOffAutoPlaySwitch() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 == null) goto L6;
        r0.b.c(false);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void turnOnAutoPlaySwitch() {
        AutoPlayHelper r0 = this.autoPlayHelper;
        if (r0 == null) goto L6;
        r0.b.c(true);
        return;
    }

    public FeedPagerListViewModel() {
        this.feedPlayerHelper = new FeedPlayerHelper(null);
        DiscardFirstValueLiveData<Integer> r0 = new DiscardFirstValueLiveData(0);
        this._feedHomeContainerSelectedIndex = r0;
        this.feedHomeContainerSelectedIndex = r0;
        Boolean r1 = Boolean.FALSE;
        this.feedHomeContainerDeliverHiddenState = new DiscardFirstValueLiveData(r1);
        this.enterCleanMode = new DiscardFirstValueLiveData(r1);
        this.enterPinchMode = new DiscardFirstValueLiveData(r1);
        this.loadMoreUiShow = new DiscardFirstValueLiveData(r1);
        this.enterSkeleton = new DiscardFirstValueLiveData(r1);
        this.isFeedVisible = true;
        this.isRefreshing = true;
        this.enableBtmComment$delegate = LazyKt.lazy(new FeedPagerListViewModel$enableBtmComment$2(this));
        this.sceneId = "homepage_hot";
        this.videoScaling = new MutableLiveData();
        this.slidesProgressPosition = new MutableLiveData();
        this.slidesProgressInfo = new MutableLiveData();
        this.slidesPlayCompletedPosition = new MutableLiveData();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public int getHasPlayCount() {
        ListState r0 = (ListState) getDataList().getValue();
        int r1 = 0;
        if (r0 == null) goto L17;
        List r2 = (List) r0.a;
        if (r2 == null) goto L18;
        int r3 = r2.size();
        int r4 = 0;
    L7:
        if (r1 >= r3) goto L13;
        if (((jz3.a) ListProtector.get(r2, r1)).e == false) goto L11;
        r4 = r4 + 1;
    L11:
        r1 = r1 + 1;
        goto L7
    L13:
        return r4;
    L18:
        return 0;
    L17:
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public List<j54.a> getHostExtensionInfo() {
        return CollectionsKt.emptyList();
    }

    public final AutoPlayHelper getAutoPlayHelper() {
        return this.autoPlayHelper;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String getCommerceClickType() {
        return this.commerceClickType;
    }

    public final String getContenScene() {
        return this.contenScene;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String getContentScene() {
        return this.contentScene;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean getEnableFollowChannel() {
        return this.enableFollowChannel;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public DiscardFirstValueLiveData<Boolean> getEnterCleanMode() {
        return this.enterCleanMode;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public DiscardFirstValueLiveData<Boolean> getEnterPinchMode() {
        return this.enterPinchMode;
    }

    public DiscardFirstValueLiveData<Boolean> getEnterSkeleton() {
        return this.enterSkeleton;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public DiscardFirstValueLiveData<Boolean> getFeedHomeContainerDeliverHiddenState() {
        return this.feedHomeContainerDeliverHiddenState;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public LiveData<Integer> getFeedHomeContainerSelectedIndex() {
        return this.feedHomeContainerSelectedIndex;
    }

    public final FeedPlayerHelper getFeedPlayerHelper() {
        return this.feedPlayerHelper;
    }

    public final FeedSeekBarHelper getFeedSeekBarHelper() {
        return this.feedSeekBarHelper;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d getISeekBar() {
        return this.feedSeekBarHelper;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public DiscardFirstValueLiveData<Boolean> getLoadMoreUiShow() {
        return this.loadMoreUiShow;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean getNeedDouyinFlag() {
        return this.needDouyinFlag;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String getOverType() {
        return this.overType;
    }

    public long getPlayTimeDurationRecord() {
        return this.playTimeDurationRecord;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public p54.b getPlayerController() {
        return this.feedPlayerHelper;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public long getPostPlayTimeDurationRecord() {
        return this.postPlayTimeDurationRecord;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public MutableLiveData<Integer> getSlidesPlayCompletedPosition() {
        return this.slidesPlayCompletedPosition;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public MutableLiveData<p> getSlidesProgressInfo() {
        return this.slidesProgressInfo;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public MutableLiveData<Integer> getSlidesProgressPosition() {
        return this.slidesProgressPosition;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String getStartType() {
        return this.startType;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public MutableLiveData<pz3.d> getVideoScaling() {
        return this.videoScaling;
    }

    public final String getWaitToConsumeEnterAid() {
        return this.waitToConsumeEnterAid;
    }

    public final String getWaitToConsumeEnterAids() {
        return this.waitToConsumeEnterAids;
    }

    public final String getWaitToConsumeEnterClientParams() {
        return this.waitToConsumeEnterClientParams;
    }

    public final String getWaitToConsumeEnterGid() {
        return this.waitToConsumeEnterGid;
    }

    public final String getWaitToConsumeEnterGids() {
        return this.waitToConsumeEnterGids;
    }

    public final String getWaitToConsumeEnterHostVideoSequence() {
        return this.waitToConsumeEnterHostVideoSequence;
    }

    public final String getWaitToConsumeEnterLiveRoomId() {
        return this.waitToConsumeEnterLiveRoomId;
    }

    public final String getWaitToConsumeEnterLocalParams() {
        return this.waitToConsumeEnterLocalParams;
    }

    public final String getWaitToConsumeEnterRequestId() {
        return this.waitToConsumeEnterRequestId;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean isFeedVisible() {
        return this.isFeedVisible;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void markDislike() {
        disLikeCurrent();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel, com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public String sceneId() {
        return this.sceneId;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addPlayDurationChangeListener(FeedSeekBarHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FeedSeekBarHelper r1 = this.feedSeekBarHelper;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.I.add(r3);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addPlayStateListener(com.bytedance.awemeopen.infra.base.player.k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        this.feedPlayerHelper.c(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        FeedSeekBarHelper r0 = this.feedSeekBarHelper;
        if (r0 == null) goto L6;
        r0.addSeekBarChangeListener(r2);
        return;
    }

    public final void initPageConfig(FeedPageConfig r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        this.feedPageConfig = r7;
        FeedPageConfig r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r7 = null;
    L5:
        String r8 = r7.getEnterAid();
        boolean r2 = true;
        if (r8 != null) goto L8;
    L11:
        boolean r9 = true;
    L12:
        if (r9 == true) goto L17;
        FeedPageConfig r10 = this.feedPageConfig;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r10 = null;
    L16:
        this.waitToConsumeEnterAid = r10.getEnterAid();
    L17:
        String r11 = this.waitToConsumeEnterAid;
        if (r11 != null) goto L20;
    L23:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L27;
    L32:
        FeedPageConfig r13 = this.feedPageConfig;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r13 = null;
    L35:
        this.waitToConsumeEnterRequestId = r13.getEnterRequestId();
        FeedPageConfig r14 = this.feedPageConfig;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r14 = null;
    L38:
        this.waitToConsumeEnterGid = r14.getEnterHostGid();
        FeedPageConfig r15 = this.feedPageConfig;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r15 = null;
    L41:
        this.waitToConsumeEnterAids = r15.getEnterAids();
        FeedPageConfig r16 = this.feedPageConfig;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r16 = null;
    L44:
        this.waitToConsumeEnterGids = r16.getEnterHostGids();
        String r17 = this.waitToConsumeEnterAids;
        if (r17 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
        this.waitToConsumeEnterAids = this.waitToConsumeEnterAid;
    L53:
        String r19 = this.waitToConsumeEnterGids;
        if (r19 != null) goto L56;
    L59:
        if (r2 == false) goto L61;
        this.waitToConsumeEnterGids = this.waitToConsumeEnterGid;
    L61:
        FeedPageConfig r20 = this.feedPageConfig;
        if (r20 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r20 = null;
    L64:
        this.waitToConsumeEnterLocalParams = r20.getEnterHostlocalParams();
        FeedPageConfig r21 = this.feedPageConfig;
        if (r21 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r21 = null;
    L67:
        this.waitToConsumeEnterClientParams = r21.getEnterHostClientParams();
        FeedPageConfig r22 = this.feedPageConfig;
        if (r22 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r22 = null;
    L70:
        this.waitToConsumeEnterHostVideoSequence = r22.getEnterHostVideoSequence();
        FeedPageConfig r23 = this.feedPageConfig;
        if (r23 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r23 = null;
    L73:
        setContentScene(r23.getContentScene());
        FeedPlayerHelper r24 = this.feedPlayerHelper;
        FeedPageConfig r3 = this.feedPageConfig;
        if (r3 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r3 = null;
    L76:
        r24.e = r3.getIgnorePageStatusControl();
        FeedPageConfig r25 = this.feedPageConfig;
        if (r25 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r25 = null;
    L79:
        this.waitToConsumeEnterLiveRoomId = r25.getLiveRoomId();
        setStartType("first_video");
        FeedPageConfig r26 = this.feedPageConfig;
        if (r26 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
    L83:
        setCommerceClickType(r0.getEcDetailParams().optString("commerce_click_type", ""));
        return;
    L82:
        r0 = r26;
        goto L83
    L56:
        if (r19.length() == 0) goto L59;
        r2 = false;
        goto L59
    L47:
        if (r17.length() == 0) goto L50;
        r18 = false;
        goto L51
    L27:
        if (com.bytedance.awemeopen.apps.framework.card.d.a == false) goto L32;
        this.waitToConsumeEnterAid = com.bytedance.awemeopen.apps.framework.card.d.b;
        FeedPageConfig r27 = this.feedPageConfig;
        if (r27 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r27 = null;
    L31:
        r27.setPreviousPage(com.bytedance.awemeopen.apps.framework.card.d.c);
        com.bytedance.awemeopen.apps.framework.card.d.a = false;
        com.bytedance.awemeopen.apps.framework.card.d.b = "";
        com.bytedance.awemeopen.apps.framework.card.d.c = "";
        goto L32
    L20:
        if (r11.length() == 0) goto L23;
        r12 = false;
        goto L25
    L8:
        if (r8.length() == 0) goto L11;
        r9 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removeObserveCommentShowState(Observer<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        getCommentShowLiveData().removeObserver(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePauseOrPlayObserver(Observer<FeedPlayerHelper.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.feedPlayerHelper.g.removeObserver(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePlayDurationChangeListener(FeedSeekBarHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FeedSeekBarHelper r1 = this.feedSeekBarHelper;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.I.remove(r3);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePlayStateListener(com.bytedance.awemeopen.infra.base.player.k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        this.feedPlayerHelper.g(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removeSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        FeedSeekBarHelper r0 = this.feedSeekBarHelper;
        if (r0 == null) goto L6;
        r0.removeSeekBarChangeListener(r2);
        return;
    }

    public final void setAutoPlayHelper(AutoPlayHelper r1) {
        this.autoPlayHelper = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setCommentShowState(int r2) {
        getCommentShowLiveData().setValue(Integer.valueOf(r2));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setCommerceClickType(String r1) {
        this.commerceClickType = r1;
    }

    public final void setContenScene(String r1) {
        this.contenScene = r1;
    }

    public void setContentScene(String r1) {
        this.contentScene = r1;
    }

    public void setEnableFollowChannel(boolean r1) {
        this.enableFollowChannel = r1;
    }

    public void setEnterCleanMode(DiscardFirstValueLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterCleanMode = r2;
    }

    public void setEnterPinchMode(DiscardFirstValueLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterPinchMode = r2;
    }

    public void setEnterSkeleton(DiscardFirstValueLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterSkeleton = r2;
    }

    public void setFeedHomeContainerDeliverHiddenState(DiscardFirstValueLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.feedHomeContainerDeliverHiddenState = r2;
    }

    public void setFeedHomeContainerSelectedIndex(LiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.feedHomeContainerSelectedIndex = r2;
    }

    public final void setFeedSeekBarHelper(FeedSeekBarHelper r1) {
        this.feedSeekBarHelper = r1;
    }

    public void setFeedVisible(boolean r1) {
        this.isFeedVisible = r1;
    }

    public void setLoadMoreUiShow(DiscardFirstValueLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadMoreUiShow = r2;
    }

    public void setNeedDouyinFlag(boolean r1) {
        this.needDouyinFlag = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setOverType(String r1) {
        this.overType = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setPlayTimeDurationRecord(long r1) {
        this.playTimeDurationRecord = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setPostPlayTimeDurationRecord(long r1) {
        this.postPlayTimeDurationRecord = r1;
    }

    public final void setRefreshing(boolean r1) {
        this.isRefreshing = r1;
    }

    public final void setSceneId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.sceneId = r2;
    }

    public void setSlidesPlayCompletedPosition(MutableLiveData<Integer> r1) {
        this.slidesPlayCompletedPosition = r1;
    }

    public void setSlidesProgressInfo(MutableLiveData<p> r1) {
        this.slidesProgressInfo = r1;
    }

    public void setSlidesProgressPosition(MutableLiveData<Integer> r1) {
        this.slidesProgressPosition = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setStartType(String r1) {
        this.startType = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setVideoAutoPlayListener(FeedPlayerHelper.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FeedPlayerHelper r1 = this.feedPlayerHelper;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.d = r3;
    }

    public void setVideoScaling(MutableLiveData<pz3.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.videoScaling = r2;
    }

    public final void setWaitToConsumeEnterAid(String r1) {
        this.waitToConsumeEnterAid = r1;
    }

    public final void setWaitToConsumeEnterAids(String r1) {
        this.waitToConsumeEnterAids = r1;
    }

    public final void setWaitToConsumeEnterClientParams(String r1) {
        this.waitToConsumeEnterClientParams = r1;
    }

    public final void setWaitToConsumeEnterGid(String r1) {
        this.waitToConsumeEnterGid = r1;
    }

    public final void setWaitToConsumeEnterGids(String r1) {
        this.waitToConsumeEnterGids = r1;
    }

    public final void setWaitToConsumeEnterHostVideoSequence(String r1) {
        this.waitToConsumeEnterHostVideoSequence = r1;
    }

    public final void setWaitToConsumeEnterLiveRoomId(String r1) {
        this.waitToConsumeEnterLiveRoomId = r1;
    }

    public final void setWaitToConsumeEnterLocalParams(String r1) {
        this.waitToConsumeEnterLocalParams = r1;
    }

    public final void setWaitToConsumeEnterRequestId(String r1) {
        this.waitToConsumeEnterRequestId = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public com.bytedance.awemeopen.infra.base.player.j toPlayRequest(r14.c r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        this.feedPlayerHelper.getClass();
        com.bytedance.awemeopen.infra.base.player.j r0 = FeedPlayerHelper.i(r9);
        FeedPageConfig r1 = this.feedPageConfig;
        FeedPageConfig r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r1 = null;
    L5:
        String r3 = r1.getEnterAid();
        boolean r4 = true;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L19;
        String r6 = r9.c();
        FeedPageConfig r7 = this.feedPageConfig;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r7 = null;
    L17:
        if (Intrinsics.areEqual(r6, r7.getEnterAid()) == false) goto L19;
    L20:
        if (r4 == false) goto L36;
        FeedPageConfig r8 = this.feedPageConfig;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r8 = null;
    L25:
        if (r8.getStartPlayPosition() <= 0) goto L36;
        FeedPageConfig r10 = this.feedPageConfig;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r10 = null;
    L30:
        if (r10.getStartPlayPosition() > r9.q()) goto L36;
        FeedPageConfig r11 = this.feedPageConfig;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
    L35:
        r0.c = r2.getStartPlayPosition();
        goto L36
    L34:
        r2 = r11;
    L36:
        return r0;
    L19:
        r4 = false;
        goto L20
    L8:
        if (r3.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public final void updateHomeContainerSelectedIndex(int r2) {
        this._feedHomeContainerSelectedIndex.setValue(Integer.valueOf(r2));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addPauseOrPlayObserver(LifecycleOwner r2, Observer<FeedPlayerHelper.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.feedPlayerHelper.g.observe(r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterForwardData(List<? extends jz3.a> r7, List<? extends jz3.a> r8) {
        Intrinsics.checkNotNullParameter(r7, "forwardData");
        Intrinsics.checkNotNullParameter(r8, "oldData");
        List<? extends jz3.a> r9 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        jz3.a r6 = (jz3.a) r4;
        r6.d = r3;
        r0.add(r6);
        r3 = r5;
        goto L4
    L9:
        List<jz3.a> r11 = CollectionsKt.toMutableList(r0);
        if (r11.isEmpty() == false) goto L14;
        return null;
    L14:
        if (r8.isEmpty() == false) goto L16;
        return r11;
    L16:
        List<? extends jz3.a> r12 = r8;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        Object r14 = r13.next();
        r1.put(((jz3.a) r14).a.c(), r14);
        goto L18
    L20:
        Map r15 = MapsKt.toMutableMap(r1);
        Iterator r16 = CollectionsKt.toMutableList(r11).iterator();
        int r17 = 0;
    L22:
        if (r16.hasNext() == false) goto L30;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        jz3.a r20 = (jz3.a) r15.remove(((jz3.a) r18).a.c());
        if (r20 == null) goto L29;
        r20.d = r17;
        ListProtector.set(r11, r17, r20);
    L29:
        r17 = r19;
        goto L22
    L30:
        int r21 = r11.size() - 1;
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r12.iterator();
    L32:
        if (r23.hasNext() == false) goto L36;
        Object r24 = r23.next();
        if (r15.containsValue((jz3.a) r24) == false) goto L32;
        r22.add(r24);
        goto L32
    L36:
        Iterator r25 = r22.iterator();
    L38:
        if (r25.hasNext() == false) goto L43;
        Object r26 = r25.next();
        int r27 = r2 + 1;
        if (r2 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        ((jz3.a) r26).d = r2 + r21;
        r2 = r27;
        goto L38
    L43:
        r11.addAll(r22);
        return r11;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterMoreData(List<? extends jz3.a> r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        List<? extends jz3.a> r7 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L10;
        Object r2 = r8.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        jz3.a r4 = (jz3.a) r2;
        r4.d = r1 + r6;
        r0.add(r4);
        r1 = r3;
        goto L4
    L10:
        return CollectionsKt.toMutableList(r0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void observeCommentShowState(LifecycleOwner r2, Observer<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        getCommentShowLiveData().observe(r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterRefreshData(List<? extends jz3.a> r2, List<? extends jz3.a> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "oldData");
        return filterMoreData(r2, r4);
    }
}

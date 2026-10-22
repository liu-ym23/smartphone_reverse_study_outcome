package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.player.AutoPlayHelper;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bb\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\nH\u0016J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J,\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\u001e\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000402H\u0016J\u0016\u00105\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000402H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\u0011\u00107\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b7\u00108J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b9\u00108J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\u0011\u0010=\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b=\u00108J\u0011\u0010>\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b>\u0010?J\b\u0010A\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020E2\u0006\u0010\u000f\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020GH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\bH\u0016J\b\u0010K\u001a\u00020\u0018H\u0016J\u001e\u0010M\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020L02H\u0016J\u0016\u0010N\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020L02H\u0016R\u0017\u0010P\u001a\u00020O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR(\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR(\u0010l\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010d\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR(\u0010q\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010d\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR(\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010d\u001a\u0004\bu\u0010n\"\u0004\bv\u0010pR(\u0010w\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010d\u001a\u0004\bx\u0010n\"\u0004\by\u0010pR(\u0010z\u001a\b\u0012\u0004\u0012\u00020\b0b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010d\u001a\u0004\b{\u0010n\"\u0004\b|\u0010pR$\u0010}\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0014\n\u0004\b}\u0010~\u001a\u0004\b}\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010~\u001a\u0005\b\u0082\u0001\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001f\u0010\u0089\u0001\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u0010\u007fR+\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R+\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u008b\u0001\u001a\u0006\b\u0091\u0001\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u008b\u0001\u001a\u0006\b\u0094\u0001\u0010\u008d\u0001\"\u0006\b\u0095\u0001\u0010\u008f\u0001R+\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u008b\u0001\u001a\u0006\b\u0097\u0001\u0010\u008d\u0001\"\u0006\b\u0098\u0001\u0010\u008f\u0001R+\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u008b\u0001\u001a\u0006\b\u009a\u0001\u0010\u008d\u0001\"\u0006\b\u009b\u0001\u0010\u008f\u0001R+\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u008b\u0001\u001a\u0006\b\u009d\u0001\u0010\u008d\u0001\"\u0006\b\u009e\u0001\u0010\u008f\u0001R+\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010\u008b\u0001\u001a\u0006\b \u0001\u0010\u008d\u0001\"\u0006\b¡\u0001\u0010\u008f\u0001R+\u0010¢\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010\u008b\u0001\u001a\u0006\b£\u0001\u0010\u008d\u0001\"\u0006\b¤\u0001\u0010\u008f\u0001R+\u0010¥\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010\u008b\u0001\u001a\u0006\b¦\u0001\u0010\u008d\u0001\"\u0006\b§\u0001\u0010\u008f\u0001R+\u0010¨\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010\u008b\u0001\u001a\u0006\b©\u0001\u0010\u008d\u0001\"\u0006\bª\u0001\u0010\u008f\u0001R+\u0010«\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010\u008b\u0001\u001a\u0006\b¬\u0001\u0010\u008d\u0001\"\u0006\b\u00ad\u0001\u0010\u008f\u0001R'\u0010®\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b®\u0001\u0010~\u001a\u0005\b¯\u0001\u0010\u007f\"\u0006\b°\u0001\u0010\u0081\u0001R)\u0010±\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R)\u0010·\u0001\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010²\u0001\u001a\u0006\b¸\u0001\u0010´\u0001\"\u0006\b¹\u0001\u0010¶\u0001R'\u0010º\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\bº\u0001\u0010~\u001a\u0005\b»\u0001\u0010\u007f\"\u0006\b¼\u0001\u0010\u0081\u0001R+\u0010½\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010\u008b\u0001\u001a\u0006\b¾\u0001\u0010\u008d\u0001\"\u0006\b¿\u0001\u0010\u008f\u0001R'\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u001b\u0010\u008b\u0001\u001a\u0006\bÀ\u0001\u0010\u008d\u0001\"\u0006\bÁ\u0001\u0010\u008f\u0001R+\u0010Â\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010\u008b\u0001\u001a\u0006\bÃ\u0001\u0010\u008d\u0001\"\u0006\bÄ\u0001\u0010\u008f\u0001R+\u0010Å\u0001\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u008b\u0001\u001a\u0006\bÆ\u0001\u0010\u008d\u0001\"\u0006\bÇ\u0001\u0010\u008f\u0001R1\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R2\u0010Ð\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ë\u0001\u001a\u0006\bÑ\u0001\u0010Í\u0001\"\u0006\bÒ\u0001\u0010Ï\u0001R5\u0010Ô\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010Ó\u0001\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Ë\u0001\u001a\u0006\bÕ\u0001\u0010Í\u0001\"\u0006\bÖ\u0001\u0010Ï\u0001R2\u0010×\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010È\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ë\u0001\u001a\u0006\bØ\u0001\u0010Í\u0001\"\u0006\bÙ\u0001\u0010Ï\u0001¨\u0006Ü\u0001"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/o;", "", BaseSwitches.V, "", "updateHomeContainerSelectedIndex", "", "isInFeedPage", "Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "config", "initPageConfig", "getPageConfig", "", "data", "oldData", "startIndex", "", "filterRefreshData", "filterMoreData", "forwardData", "filterForwardData", "onCleared", "", "getCurrentPosition", "", "sceneId", "state", "setCommentShowState", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper$c;", "listener", "removePlayDurationChangeListener", "addPlayDurationChangeListener", "Lcom/bytedance/awemeopen/infra/base/player/k;", "statusListener", "addPlayStateListener", "removePlayStateListener", "getWatchDuration", "getDuration", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/d;", "getISeekBar", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/d$a;", "addSeekBarChangeListener", "removeSeekBarChangeListener", "playerIsPlaying", "playPlayer", "markDislike", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "observeCommentShowState", "removeObserveCommentShowState", "getHasPlayCount", "getAutoPlayState", "()Ljava/lang/Boolean;", "showAutoPlaySwitch", "turnOnAutoPlaySwitch", "turnOffAutoPlaySwitch", "doAutoPlay", "canAutoPlay", "timeOnLiveRoom", "()Ljava/lang/Long;", "Lcom/bytedance/awemeopen/infra/base/player/g;", "getPlayer", "Lp54/b;", "getPlayerController", "Lr14/c;", "Lcom/bytedance/awemeopen/infra/base/player/j;", "toPlayRequest", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper$c;", "setVideoAutoPlayListener", "removeVideoAutoPlayListener", "ignorePageStatusControl", "fullscreenButtonDelayMs", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper$b;", "addPauseOrPlayObserver", "removePauseOrPlayObserver", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "feedPlayerHelper", "Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "getFeedPlayerHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/FeedPlayerHelper;", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "autoPlayHelper", "Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "getAutoPlayHelper", "()Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "setAutoPlayHelper", "(Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;)V", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "feedSeekBarHelper", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "getFeedSeekBarHelper", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "setFeedSeekBarHelper", "(Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;)V", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "_feedHomeContainerSelectedIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "Landroidx/lifecycle/LiveData;", "feedHomeContainerSelectedIndex", "Landroidx/lifecycle/LiveData;", "getFeedHomeContainerSelectedIndex", "()Landroidx/lifecycle/LiveData;", "setFeedHomeContainerSelectedIndex", "(Landroidx/lifecycle/LiveData;)V", "feedHomeContainerDeliverHiddenState", "getFeedHomeContainerDeliverHiddenState", "()Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "setFeedHomeContainerDeliverHiddenState", "(Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;)V", "enterCleanMode", "getEnterCleanMode", "setEnterCleanMode", "enterPinchMode", "getEnterPinchMode", "setEnterPinchMode", "loadMoreUiShow", "getLoadMoreUiShow", "setLoadMoreUiShow", "enterSkeleton", "getEnterSkeleton", "setEnterSkeleton", "isFeedVisible", "Z", "()Z", "setFeedVisible", "(Z)V", "isRefreshing", "setRefreshing", "feedPageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/recfeed/FeedPageConfig;", "enableBtmComment$delegate", "Lkotlin/Lazy;", "getEnableBtmComment", "enableBtmComment", "waitToConsumeEnterAid", "Ljava/lang/String;", "getWaitToConsumeEnterAid", "()Ljava/lang/String;", "setWaitToConsumeEnterAid", "(Ljava/lang/String;)V", "waitToConsumeEnterRequestId", "getWaitToConsumeEnterRequestId", "setWaitToConsumeEnterRequestId", "waitToConsumeEnterGid", "getWaitToConsumeEnterGid", "setWaitToConsumeEnterGid", "waitToConsumeEnterAids", "getWaitToConsumeEnterAids", "setWaitToConsumeEnterAids", "waitToConsumeEnterGids", "getWaitToConsumeEnterGids", "setWaitToConsumeEnterGids", "waitToConsumeEnterLocalParams", "getWaitToConsumeEnterLocalParams", "setWaitToConsumeEnterLocalParams", "waitToConsumeEnterClientParams", "getWaitToConsumeEnterClientParams", "setWaitToConsumeEnterClientParams", "waitToConsumeEnterHostVideoSequence", "getWaitToConsumeEnterHostVideoSequence", "setWaitToConsumeEnterHostVideoSequence", "contentScene", "getContentScene", "setContentScene", "startType", "getStartType", "setStartType", "overType", "getOverType", "setOverType", "enableFollowChannel", "getEnableFollowChannel", "setEnableFollowChannel", "playTimeDurationRecord", "J", "getPlayTimeDurationRecord", "()J", "setPlayTimeDurationRecord", "(J)V", "postPlayTimeDurationRecord", "getPostPlayTimeDurationRecord", "setPostPlayTimeDurationRecord", "needDouyinFlag", "getNeedDouyinFlag", "setNeedDouyinFlag", "contenScene", "getContenScene", "setContenScene", "getSceneId", "setSceneId", "waitToConsumeEnterLiveRoomId", "getWaitToConsumeEnterLiveRoomId", "setWaitToConsumeEnterLiveRoomId", "commerceClickType", "getCommerceClickType", "setCommerceClickType", "Landroidx/lifecycle/MutableLiveData;", "Lpz3/d;", "videoScaling", "Landroidx/lifecycle/MutableLiveData;", "getVideoScaling", "()Landroidx/lifecycle/MutableLiveData;", "setVideoScaling", "(Landroidx/lifecycle/MutableLiveData;)V", "slidesProgressPosition", "getSlidesProgressPosition", "setSlidesProgressPosition", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/p;", "slidesProgressInfo", "getSlidesProgressInfo", "setSlidesProgressInfo", "slidesPlayCompletedPosition", "getSlidesPlayCompletedPosition", "setSlidesPlayCompletedPosition", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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

    public void setHostExtraInfo(Map<String, String> r100) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean canAutoPlay() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.a());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void doAutoPlay() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.a() == false) goto L34;
        int r101 = r100.f197228a.getCurrentIndex();
        ListState<List<jz3.a>> r102 = r100.f197228a.getDataList().getValue();
        r14.c r103 = null;
        if (r102 == null) goto L12;
        List<jz3.a> r104 = r102.f196927a;
        if (r104 == null) goto L12;
        jz3.a r105 = (jz3.a) CollectionsKt.getOrNull(r104, r101);
    L13:
        ListState<List<jz3.a>> r106 = r100.f197228a.getDataList().getValue();
        if (r106 == null) goto L18;
        List<jz3.a> r107 = r106.f196927a;
        if (r107 == null) goto L18;
        jz3.a r108 = (jz3.a) CollectionsKt.getOrNull(r107, r101 + 1);
    L20:
        if (r108 != null) goto L23;
        AoLogger.b("AutoPlayHelper", new Object[]{"feedItem is null"});
        return;
    L23:
        if (r100.f197231d == false) goto L25;
        r100.f197231d = false;
    L30:
        r108.f501173a.f535638t = true;
        r100.f197232e.setValue(Integer.valueOf(r101 + 1));
        return;
    L25:
        if (r105 == null) goto L27;
        r103 = r105.f501173a;
    L27:
        if (r103 == null) goto L30;
        r103.f535638t = true;
    L18:
        r108 = null;
    L12:
        r105 = null;
        goto L13
    }

    public long fullscreenButtonDelayMs() {
        FeedPageConfig r100 = this.feedPageConfig;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r100 = null;
    L6:
        return r100.getFullscreenButtonAppearDelayMs();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean getAutoPlayState() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.f197229b.getAutoPlayState());
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
        FeedPageConfig r100 = this.feedPageConfig;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        return null;
    L6:
        return r100;
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
        return this.feedPlayerHelper.f197246e;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public boolean isInFeedPage() {
        Integer r100 = this._feedHomeContainerSelectedIndex.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 0) goto L8;
        return true;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        FeedPlayerHelper r101 = this.feedPlayerHelper;
        r101.getClass();
        FeedPlayerHelper.d();
        r101.f197243b.clear();
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
        this.feedPlayerHelper.f197245d = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Boolean showAutoPlaySwitch() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 == null) goto L5;
        r100.f197229b.showAutoPlaySwitch();
        return Boolean.TRUE;
    L5:
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public Long timeOnLiveRoom() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.f197229b.timeOnLiveRoom());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void turnOffAutoPlaySwitch() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 == null) goto L6;
        r100.f197229b.c(false);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void turnOnAutoPlaySwitch() {
        AutoPlayHelper r100 = this.autoPlayHelper;
        if (r100 == null) goto L6;
        r100.f197229b.c(true);
        return;
    }

    public FeedPagerListViewModel() {
        this.feedPlayerHelper = new FeedPlayerHelper(null);
        DiscardFirstValueLiveData<Integer> r100 = new DiscardFirstValueLiveData(0);
        this._feedHomeContainerSelectedIndex = r100;
        this.feedHomeContainerSelectedIndex = r100;
        Boolean r101 = Boolean.FALSE;
        this.feedHomeContainerDeliverHiddenState = new DiscardFirstValueLiveData(r101);
        this.enterCleanMode = new DiscardFirstValueLiveData(r101);
        this.enterPinchMode = new DiscardFirstValueLiveData(r101);
        this.loadMoreUiShow = new DiscardFirstValueLiveData(r101);
        this.enterSkeleton = new DiscardFirstValueLiveData(r101);
        this.isFeedVisible = true;
        this.isRefreshing = true;
        this.enableBtmComment$delegate = LazyKt.lazy(new FeedPagerListViewModel$enableBtmComment$2(this));
        this.sceneId = UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT;
        this.videoScaling = new MutableLiveData();
        this.slidesProgressPosition = new MutableLiveData();
        this.slidesProgressInfo = new MutableLiveData();
        this.slidesPlayCompletedPosition = new MutableLiveData();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public int getHasPlayCount() {
        ListState<List<jz3.a>> r100 = getDataList().getValue();
        int r101 = 0;
        if (r100 == null) goto L17;
        List<jz3.a> r102 = r100.f196927a;
        if (r102 == null) goto L18;
        int r103 = r102.size();
        int r104 = 0;
    L7:
        if (r101 >= r103) goto L13;
        if (((jz3.a) ListProtector.get(r102, r101)).f501177e == false) goto L11;
        r104 = r104 + 1;
    L11:
        r101 = r101 + 1;
        goto L7
    L13:
        return r104;
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
    public void addPlayDurationChangeListener(FeedSeekBarHelper.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FeedSeekBarHelper r101 = this.feedSeekBarHelper;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.I.add(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addPlayStateListener(com.bytedance.awemeopen.infra.base.player.k r100) {
        Intrinsics.checkNotNullParameter(r100, "statusListener");
        this.feedPlayerHelper.c(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FeedSeekBarHelper r101 = this.feedSeekBarHelper;
        if (r101 == null) goto L6;
        r101.addSeekBarChangeListener(r100);
        return;
    }

    public final void initPageConfig(FeedPageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.feedPageConfig = r100;
        FeedPageConfig r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r100 = null;
    L5:
        String r102 = r100.getEnterAid();
        boolean r103 = true;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L17;
        FeedPageConfig r105 = this.feedPageConfig;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r105 = null;
    L16:
        this.waitToConsumeEnterAid = r105.getEnterAid();
    L17:
        String r106 = this.waitToConsumeEnterAid;
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L27;
    L32:
        FeedPageConfig r108 = this.feedPageConfig;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r108 = null;
    L35:
        this.waitToConsumeEnterRequestId = r108.getEnterRequestId();
        FeedPageConfig r109 = this.feedPageConfig;
        if (r109 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r109 = null;
    L38:
        this.waitToConsumeEnterGid = r109.getEnterHostGid();
        FeedPageConfig r110 = this.feedPageConfig;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r110 = null;
    L41:
        this.waitToConsumeEnterAids = r110.getEnterAids();
        FeedPageConfig r111 = this.feedPageConfig;
        if (r111 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r111 = null;
    L44:
        this.waitToConsumeEnterGids = r111.getEnterHostGids();
        String r112 = this.waitToConsumeEnterAids;
        if (r112 != null) goto L47;
    L50:
        boolean r113 = true;
    L51:
        if (r113 == false) goto L53;
        this.waitToConsumeEnterAids = this.waitToConsumeEnterAid;
    L53:
        String r114 = this.waitToConsumeEnterGids;
        if (r114 != null) goto L56;
    L59:
        if (r103 == false) goto L61;
        this.waitToConsumeEnterGids = this.waitToConsumeEnterGid;
    L61:
        FeedPageConfig r115 = this.feedPageConfig;
        if (r115 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r115 = null;
    L64:
        this.waitToConsumeEnterLocalParams = r115.getEnterHostlocalParams();
        FeedPageConfig r116 = this.feedPageConfig;
        if (r116 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r116 = null;
    L67:
        this.waitToConsumeEnterClientParams = r116.getEnterHostClientParams();
        FeedPageConfig r117 = this.feedPageConfig;
        if (r117 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r117 = null;
    L70:
        this.waitToConsumeEnterHostVideoSequence = r117.getEnterHostVideoSequence();
        FeedPageConfig r118 = this.feedPageConfig;
        if (r118 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r118 = null;
    L73:
        setContentScene(r118.getContentScene());
        FeedPlayerHelper r119 = this.feedPlayerHelper;
        FeedPageConfig r120 = this.feedPageConfig;
        if (r120 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r120 = null;
    L76:
        r119.f197246e = r120.getIgnorePageStatusControl();
        FeedPageConfig r121 = this.feedPageConfig;
        if (r121 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r121 = null;
    L79:
        this.waitToConsumeEnterLiveRoomId = r121.getLiveRoomId();
        setStartType("first_video");
        FeedPageConfig r122 = this.feedPageConfig;
        if (r122 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
    L83:
        setCommerceClickType(r101.getEcDetailParams().optString("commerce_click_type", ""));
        return;
    L82:
        r101 = r122;
        goto L83
    L56:
        if (r114.length() == 0) goto L59;
        r103 = false;
        goto L59
    L47:
        if (r112.length() == 0) goto L50;
        r113 = false;
        goto L51
    L27:
        if (com.bytedance.awemeopen.apps.framework.card.d.f193815a == false) goto L32;
        this.waitToConsumeEnterAid = com.bytedance.awemeopen.apps.framework.card.d.f193816b;
        FeedPageConfig r123 = this.feedPageConfig;
        if (r123 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r123 = null;
    L31:
        r123.setPreviousPage(com.bytedance.awemeopen.apps.framework.card.d.f193817c);
        com.bytedance.awemeopen.apps.framework.card.d.f193815a = false;
        com.bytedance.awemeopen.apps.framework.card.d.f193816b = "";
        com.bytedance.awemeopen.apps.framework.card.d.f193817c = "";
        goto L32
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L25
    L8:
        if (r102.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removeObserveCommentShowState(Observer<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        getCommentShowLiveData().removeObserver(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePauseOrPlayObserver(Observer<FeedPlayerHelper.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.feedPlayerHelper.f197248g.removeObserver(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePlayDurationChangeListener(FeedSeekBarHelper.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FeedSeekBarHelper r101 = this.feedSeekBarHelper;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.I.remove(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removePlayStateListener(com.bytedance.awemeopen.infra.base.player.k r100) {
        Intrinsics.checkNotNullParameter(r100, "statusListener");
        this.feedPlayerHelper.g(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void removeSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FeedSeekBarHelper r101 = this.feedSeekBarHelper;
        if (r101 == null) goto L6;
        r101.removeSeekBarChangeListener(r100);
        return;
    }

    public final void setAutoPlayHelper(AutoPlayHelper r100) {
        this.autoPlayHelper = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setCommentShowState(int r100) {
        getCommentShowLiveData().setValue(Integer.valueOf(r100));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setCommerceClickType(String r100) {
        this.commerceClickType = r100;
    }

    public final void setContenScene(String r100) {
        this.contenScene = r100;
    }

    public void setContentScene(String r100) {
        this.contentScene = r100;
    }

    public void setEnableFollowChannel(boolean r100) {
        this.enableFollowChannel = r100;
    }

    public void setEnterCleanMode(DiscardFirstValueLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterCleanMode = r100;
    }

    public void setEnterPinchMode(DiscardFirstValueLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterPinchMode = r100;
    }

    public void setEnterSkeleton(DiscardFirstValueLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterSkeleton = r100;
    }

    public void setFeedHomeContainerDeliverHiddenState(DiscardFirstValueLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.feedHomeContainerDeliverHiddenState = r100;
    }

    public void setFeedHomeContainerSelectedIndex(LiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.feedHomeContainerSelectedIndex = r100;
    }

    public final void setFeedSeekBarHelper(FeedSeekBarHelper r100) {
        this.feedSeekBarHelper = r100;
    }

    public void setFeedVisible(boolean r100) {
        this.isFeedVisible = r100;
    }

    public void setLoadMoreUiShow(DiscardFirstValueLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadMoreUiShow = r100;
    }

    public void setNeedDouyinFlag(boolean r100) {
        this.needDouyinFlag = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setOverType(String r100) {
        this.overType = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setPlayTimeDurationRecord(long r100) {
        this.playTimeDurationRecord = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setPostPlayTimeDurationRecord(long r100) {
        this.postPlayTimeDurationRecord = r100;
    }

    public final void setRefreshing(boolean r100) {
        this.isRefreshing = r100;
    }

    public final void setSceneId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sceneId = r100;
    }

    public void setSlidesPlayCompletedPosition(MutableLiveData<Integer> r100) {
        this.slidesPlayCompletedPosition = r100;
    }

    public void setSlidesProgressInfo(MutableLiveData<p> r100) {
        this.slidesProgressInfo = r100;
    }

    public void setSlidesProgressPosition(MutableLiveData<Integer> r100) {
        this.slidesProgressPosition = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setStartType(String r100) {
        this.startType = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void setVideoAutoPlayListener(FeedPlayerHelper.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        FeedPlayerHelper r101 = this.feedPlayerHelper;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f197245d = r100;
    }

    public void setVideoScaling(MutableLiveData<pz3.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoScaling = r100;
    }

    public final void setWaitToConsumeEnterAid(String r100) {
        this.waitToConsumeEnterAid = r100;
    }

    public final void setWaitToConsumeEnterAids(String r100) {
        this.waitToConsumeEnterAids = r100;
    }

    public final void setWaitToConsumeEnterClientParams(String r100) {
        this.waitToConsumeEnterClientParams = r100;
    }

    public final void setWaitToConsumeEnterGid(String r100) {
        this.waitToConsumeEnterGid = r100;
    }

    public final void setWaitToConsumeEnterGids(String r100) {
        this.waitToConsumeEnterGids = r100;
    }

    public final void setWaitToConsumeEnterHostVideoSequence(String r100) {
        this.waitToConsumeEnterHostVideoSequence = r100;
    }

    public final void setWaitToConsumeEnterLiveRoomId(String r100) {
        this.waitToConsumeEnterLiveRoomId = r100;
    }

    public final void setWaitToConsumeEnterLocalParams(String r100) {
        this.waitToConsumeEnterLocalParams = r100;
    }

    public final void setWaitToConsumeEnterRequestId(String r100) {
        this.waitToConsumeEnterRequestId = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public com.bytedance.awemeopen.infra.base.player.j toPlayRequest(r14.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.feedPlayerHelper.getClass();
        com.bytedance.awemeopen.infra.base.player.j r101 = FeedPlayerHelper.i(r100);
        FeedPageConfig r102 = this.feedPageConfig;
        FeedPageConfig r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r102 = null;
    L5:
        String r104 = r102.getEnterAid();
        boolean r105 = true;
        if (r104 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L19;
        String r107 = r100.c();
        FeedPageConfig r108 = this.feedPageConfig;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r108 = null;
    L17:
        if (Intrinsics.areEqual(r107, r108.getEnterAid()) == false) goto L19;
    L20:
        if (r105 == false) goto L36;
        FeedPageConfig r109 = this.feedPageConfig;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r109 = null;
    L25:
        if (r109.getStartPlayPosition() <= 0) goto L36;
        FeedPageConfig r110 = this.feedPageConfig;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
        r110 = null;
    L30:
        if (r110.getStartPlayPosition() > r100.q()) goto L36;
        FeedPageConfig r111 = this.feedPageConfig;
        if (r111 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("feedPageConfig");
    L35:
        r101.f198761c = r103.getStartPlayPosition();
        goto L36
    L34:
        r103 = r111;
    L36:
        return r101;
    L19:
        r105 = false;
        goto L20
    L8:
        if (r104.length() == 0) goto L11;
        r106 = false;
        goto L12
    }

    public final void updateHomeContainerSelectedIndex(int r100) {
        this._feedHomeContainerSelectedIndex.setValue(Integer.valueOf(r100));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void addPauseOrPlayObserver(LifecycleOwner r100, Observer<FeedPlayerHelper.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.feedPlayerHelper.f197248g.observe(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterForwardData(List<? extends jz3.a> r100, List<? extends jz3.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "forwardData");
        Intrinsics.checkNotNullParameter(r101, "oldData");
        List<? extends jz3.a> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r104.hasNext() == false) goto L9;
        Object r107 = r104.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        jz3.a r109 = (jz3.a) r107;
        r109.f501176d = r106;
        r103.add(r109);
        r106 = r108;
        goto L4
    L9:
        List<jz3.a> r110 = CollectionsKt.toMutableList(r103);
        if (r110.isEmpty() == false) goto L14;
        return null;
    L14:
        if (r101.isEmpty() == false) goto L16;
        return r110;
    L16:
        List<? extends jz3.a> r111 = r101;
        LinkedHashMap r112 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r111, 10)), 16));
        Iterator<T> r113 = r111.iterator();
    L18:
        if (r113.hasNext() == false) goto L20;
        Object r114 = r113.next();
        r112.put(((jz3.a) r114).f501173a.c(), r114);
        goto L18
    L20:
        Map r115 = MapsKt.toMutableMap(r112);
        Iterator r116 = CollectionsKt.toMutableList(r110).iterator();
        int r117 = 0;
    L22:
        if (r116.hasNext() == false) goto L30;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        jz3.a r120 = (jz3.a) r115.remove(((jz3.a) r118).f501173a.c());
        if (r120 == null) goto L29;
        r120.f501176d = r117;
        ListProtector.set(r110, r117, r120);
    L29:
        r117 = r119;
        goto L22
    L30:
        int r121 = r110.size() - 1;
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r111.iterator();
    L32:
        if (r123.hasNext() == false) goto L36;
        Object r124 = r123.next();
        if (r115.containsValue((jz3.a) r124) == false) goto L32;
        r122.add(r124);
        goto L32
    L36:
        Iterator r125 = r122.iterator();
    L38:
        if (r125.hasNext() == false) goto L43;
        Object r126 = r125.next();
        int r127 = r105 + 1;
        if (r105 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        ((jz3.a) r126).f501176d = r105 + r121;
        r105 = r127;
        goto L38
    L43:
        r110.addAll(r122);
        return r110;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterMoreData(List<? extends jz3.a> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<? extends jz3.a> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L10;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        jz3.a r108 = (jz3.a) r106;
        r108.f501176d = r105 + r101;
        r103.add(r108);
        r105 = r107;
        goto L4
    L10:
        return CollectionsKt.toMutableList(r103);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.o
    public void observeCommentShowState(LifecycleOwner r100, Observer<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        getCommentShowLiveData().observe(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel
    public List<jz3.a> filterRefreshData(List<? extends jz3.a> r100, List<? extends jz3.a> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "oldData");
        return filterMoreData(r100, r102);
    }
}

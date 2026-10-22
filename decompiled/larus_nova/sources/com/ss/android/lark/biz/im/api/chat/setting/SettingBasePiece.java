package com.ss.android.lark.biz.im.api.chat.setting;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.piece.core.LifecycleOwnerPiece;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016J\u0013\u0010\u0005\u001a\u00028\u00002\u0006\u00102\u001a\u00020\n¢\u0006\u0002\u00103J\u0013\u0010\u0007\u001a\u00028\u00002\u0006\u00102\u001a\u00020\n¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00002\b\u00104\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u00105J\b\u00106\u001a\u0004\u0018\u00010\u001dJ\b\u00107\u001a\u00020%H\u0014J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020%H\u0014J\b\u0010:\u001a\u000200H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\n\u0010;\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u000200H\u0016J\u0006\u0010>\u001a\u00020%J\u0010\u0010?\u001a\u0002002\b\u0010@\u001a\u0004\u0018\u00010#J\n\u0010A\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010B\u001a\u0002002\u0006\u00102\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0013H\u0004J\u001a\u0010D\u001a\u0002002\b\u0010E\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\nH\u0002J\"\u0010F\u001a\u0002002\b\u0010G\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0013H\u0002J\u0018\u0010H\u001a\u0002002\u0006\u0010>\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0004J\u0015\u0010I\u001a\u00028\u00002\u0006\u0010I\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u000200H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ss/android/lark/biz/im/api/chat/setting/SettingBasePiece;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/piece/core/LifecycleOwnerPiece;", "<init>", "()V", "topDivider", "Landroid/view/View;", "bottomDivider", BuyNowCloseMethod.MASK, "topDividerType", "Lcom/ss/android/lark/biz/im/api/chat/setting/DividerType;", "getTopDividerType", "()Lcom/ss/android/lark/biz/im/api/chat/setting/DividerType;", "setTopDividerType", "(Lcom/ss/android/lark/biz/im/api/chat/setting/DividerType;)V", "bottomDividerType", "getBottomDividerType", "setBottomDividerType", "containerHeightDp", "", "containerHeightType", "Lcom/ss/android/lark/biz/im/api/chat/setting/ContainerHeightType;", "itemType", "", "getItemType", "()I", "itemType$delegate", "Lkotlin/Lazy;", "contentViewClickListener", "Landroid/view/View$OnClickListener;", "getContentViewClickListener", "()Landroid/view/View$OnClickListener;", "setContentViewClickListener", "(Landroid/view/View$OnClickListener;)V", "callback", "Lcom/ss/android/lark/biz/im/api/chat/setting/SettingBasePiece$Callback;", "isEnable", "", "()Z", "setEnable", "(Z)V", "isFirstAddMask", "getView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "layoutConfig", "Landroid/view/ViewGroup$MarginLayoutParams;", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "type", "(Lcom/ss/android/lark/biz/im/api/chat/setting/DividerType;)Ljava/lang/Object;", "onClickListener", "(Landroid/view/View$OnClickListener;)Ljava/lang/Object;", "getClickListener", "isDefaultVisible", "updateContentViewEnable", "isEnableState", "registerShareData", "getContentClickListener", "isSetCommonBg", VideoEventOneOutSync.END_TYPE_FINISH, "isVisible", "setCallback", "cb", "getCallback", "containerHeight", "newHeightDp", "updateDividerType", "dividerView", "updateContainerHeight", "containerView", "updateContentViewState", RemoteMessageConst.Notification.VISIBILITY, "(I)Ljava/lang/Object;", "onMaskViewClick", "Callback", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SettingBasePiece<T> extends LifecycleOwnerPiece<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f410072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f410073g;

    public View.OnClickListener b() {
        return null;
    }

    public void c() {
    }

    public SettingBasePiece() {
        DividerType r100 = DividerType.HIDDEN;
        ContainerHeightType r101 = ContainerHeightType.FIXED_HEIGHT;
        this.f410072f = LazyKt.lazy(new SettingBasePiece$itemType$2(this));
        this.f410073g = b();
    }

    @Override // com.ss.android.lark.piece.core.LifecycleOwnerPiece, com.ss.android.lark.piece.core.Piece
    public final void onCreate() {
        super.onCreate();
        if (this.f438639b == 0) goto L6;
        this.f438639b = 0;
    L6:
        c();
    }

    @Override // com.ss.android.lark.piece.core.LifecycleOwnerPiece, com.ss.android.lark.piece.core.Piece
    public final void onDestroy() {
        super.onDestroy();
    }
}

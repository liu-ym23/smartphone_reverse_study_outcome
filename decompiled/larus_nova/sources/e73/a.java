package e73;

import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Le73/a;", "", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "afterRenderActions", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "beforeRenderActions", "b", "pageSlideActions", "f", "pageSlideAfterCommentActions", ce.f26391f, "enterForegroundActions", "c", "halfExpandToFullActions", "e", "fullPackToHalfActions", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("after_render_actions")
    private final IAction afterRenderActions;

    @SerializedName("before_render_actions")
    private final IAction beforeRenderActions;

    @SerializedName("enter_foreground_actions")
    private final IAction enterForegroundActions;

    @SerializedName("full_pack_to_half_actions")
    private final IAction fullPackToHalfActions;

    @SerializedName("half_expand_to_full_actions")
    private final IAction halfExpandToFullActions;

    @SerializedName("page_slide_actions")
    private final IAction pageSlideActions;

    @SerializedName("page_slide_after_comment_actions")
    private final IAction pageSlideAfterCommentActions;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.afterRenderActions, r101.afterRenderActions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.beforeRenderActions, r101.beforeRenderActions) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageSlideActions, r101.pageSlideActions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageSlideAfterCommentActions, r101.pageSlideAfterCommentActions) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterForegroundActions, r101.enterForegroundActions) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.halfExpandToFullActions, r101.halfExpandToFullActions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fullPackToHalfActions, r101.fullPackToHalfActions) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        IAction r100 = this.afterRenderActions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IAction r104 = this.beforeRenderActions;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.pageSlideActions;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IAction r110 = this.pageSlideAfterCommentActions;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        IAction r113 = this.enterForegroundActions;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        IAction r116 = this.halfExpandToFullActions;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        IAction r119 = this.fullPackToHalfActions;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionGroup(afterRenderActions=" + this.afterRenderActions + ", beforeRenderActions=" + this.beforeRenderActions + ", pageSlideActions=" + this.pageSlideActions + ", pageSlideAfterCommentActions=" + this.pageSlideAfterCommentActions + ", enterForegroundActions=" + this.enterForegroundActions + ", halfExpandToFullActions=" + this.halfExpandToFullActions + ", fullPackToHalfActions=" + this.fullPackToHalfActions + ")";
    }

    public a() {
        this.afterRenderActions = null;
        this.beforeRenderActions = null;
        this.pageSlideActions = null;
        this.pageSlideAfterCommentActions = null;
        this.enterForegroundActions = null;
        this.halfExpandToFullActions = null;
        this.fullPackToHalfActions = null;
    }

    public final IAction a() {
        return this.afterRenderActions;
    }

    public final IAction b() {
        return this.beforeRenderActions;
    }

    public final IAction c() {
        return this.enterForegroundActions;
    }

    public final IAction d() {
        return this.fullPackToHalfActions;
    }

    public final IAction e() {
        return this.halfExpandToFullActions;
    }

    public final IAction f() {
        return this.pageSlideActions;
    }

    public final IAction g() {
        return this.pageSlideAfterCommentActions;
    }
}

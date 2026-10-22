package com.bytedance.ee.bear.bitable.panel;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010R\u001a\u00020S¢\u0006\u0002\u0010TR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001e\u0010(\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001e\u0010+\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR\u001c\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001e\u0010B\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u001c\u0010E\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR\u001e\u0010H\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/Icon;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "udKey", "", "getUdKey", "()Ljava/lang/String;", "setUdKey", "(Ljava/lang/String;)V", "imgRes", "", "getImgRes", "()Ljava/lang/Integer;", "setImgRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "url", "getUrl", "setUrl", "id", "getId", "setId", "gif", "getGif", "setGif", "isSync", "", "()Z", "setSync", "(Z)V", "placeholderRes", "getPlaceholderRes", "setPlaceholderRes", "errorRes", "getErrorRes", "setErrorRes", "iconKey", "getIconKey", "setIconKey", "iconType", "getIconType", "setIconType", "style", "getStyle", "setStyle", "clickAction", "getClickAction", "setClickAction", "clickActionPayload", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickActionPayload", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickActionPayload", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "iconRadius", "getIconRadius", "()I", "setIconRadius", "(I)V", "iconTintColor", "getIconTintColor", "setIconTintColor", "iconInfo", "getIconInfo", "setIconInfo", "enumIcon", "getEnumIcon", "setEnumIcon", "visibleType", "getVisibleType", "setVisibleType", "loading", "getLoading", "()Ljava/lang/Boolean;", "setLoading", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", e1.REPLY_ACTION_APPLY, "", "imageView", "Landroid/widget/ImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "VisibleType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Icon implements NonProguard {
    public static final String VisibleForSelected = "VisibleForSelected";
    public static final a VisibleType = null;
    private String clickAction;
    private ActionPayload clickActionPayload;
    private Integer enumIcon;
    private Integer errorRes;
    private Integer gif;
    private String iconInfo;
    private String iconKey;
    private int iconRadius;
    private String iconTintColor;
    private Integer iconType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214833id;
    private Integer imgRes;
    private boolean isSync;
    private Boolean loading;
    private Integer placeholderRes;
    private Integer style;
    private String udKey;
    private String url;
    private String visibleType;

    public static final class a {
        public a() {
        }
    }

    static {
        VisibleType = new a();
    }

    public Icon() {
    }

    public final String getClickAction() {
        return this.clickAction;
    }

    public final ActionPayload getClickActionPayload() {
        return this.clickActionPayload;
    }

    public final Integer getEnumIcon() {
        return this.enumIcon;
    }

    public final Integer getErrorRes() {
        return this.errorRes;
    }

    public final Integer getGif() {
        return this.gif;
    }

    public final String getIconInfo() {
        return this.iconInfo;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final int getIconRadius() {
        return this.iconRadius;
    }

    public final String getIconTintColor() {
        return this.iconTintColor;
    }

    public final Integer getIconType() {
        return this.iconType;
    }

    public final String getId() {
        return this.f214833id;
    }

    public final Integer getImgRes() {
        return this.imgRes;
    }

    public final Boolean getLoading() {
        return this.loading;
    }

    public final Integer getPlaceholderRes() {
        return this.placeholderRes;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final String getUdKey() {
        return this.udKey;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVisibleType() {
        return this.visibleType;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final void apply(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        e.i(r100, this);
    }

    public final Integer getImgRes(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = this.imgRes;
        if (r101 != null) goto L52;
        Integer r102 = this.enumIcon;
        if (r102 == null) goto L50;
        if (r102 != null) goto L10;
    L12:
        if (r102 != null) goto L15;
    L17:
        if (r102 != null) goto L20;
    L22:
        if (r102 != null) goto L25;
    L27:
        if (r102 != null) goto L30;
    L32:
        if (r102 != null) goto L35;
    L37:
        if (r102 != null) goto L40;
    L42:
        if (r102 != null) goto L45;
    L47:
        int r103 = R.drawable.ud_icon_bitableunknow_outlined;
    L51:
        return Integer.valueOf(r103);
    L45:
        if (r102.intValue() != 7) goto L47;
        r103 = R.drawable.ccm_empty_negative_error;
        goto L51
    L40:
        if (r102.intValue() != 6) goto L42;
        r103 = R.drawable.ud_icon_loading_outlined;
        goto L51
    L35:
        if (r102.intValue() != 5) goto L37;
        r103 = R.drawable.ccm_empty_positive_complete;
        goto L51
    L30:
        if (r102.intValue() != 4) goto L32;
        r103 = R.drawable.ccm_empty_neutral_search_failed;
        goto L51
    L25:
        if (r102.intValue() != 3) goto L27;
        r103 = R.drawable.ccm_empty_neutral_no_access;
        goto L51
    L20:
        if (r102.intValue() != 2) goto L22;
    L21:
        r103 = R.drawable.ccm_empty_neutral_no_content;
        goto L51
    L15:
        if (r102.intValue() != 1) goto L17;
        r103 = R.drawable.bitable_catalog_item_arrow_down;
        goto L51
    L10:
        if (r102.intValue() != 0) goto L12;
    L50:
        return Integer.valueOf(EPanelItemIcon.getEPanelItemIconById(r100, this.f214833id, this.udKey));
    L52:
        return r101;
    }

    public final void setClickAction(String r100) {
        this.clickAction = r100;
    }

    public final void setClickActionPayload(ActionPayload r100) {
        this.clickActionPayload = r100;
    }

    public final void setEnumIcon(Integer r100) {
        this.enumIcon = r100;
    }

    public final void setErrorRes(Integer r100) {
        this.errorRes = r100;
    }

    public final void setGif(Integer r100) {
        this.gif = r100;
    }

    public final void setIconInfo(String r100) {
        this.iconInfo = r100;
    }

    public final void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public final void setIconRadius(int r100) {
        this.iconRadius = r100;
    }

    public final void setIconTintColor(String r100) {
        this.iconTintColor = r100;
    }

    public final void setIconType(Integer r100) {
        this.iconType = r100;
    }

    public final void setId(String r100) {
        this.f214833id = r100;
    }

    public final void setImgRes(Integer r100) {
        this.imgRes = r100;
    }

    public final void setLoading(Boolean r100) {
        this.loading = r100;
    }

    public final void setPlaceholderRes(Integer r100) {
        this.placeholderRes = r100;
    }

    public final void setStyle(Integer r100) {
        this.style = r100;
    }

    public final void setSync(boolean r100) {
        this.isSync = r100;
    }

    public final void setUdKey(String r100) {
        this.udKey = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVisibleType(String r100) {
        this.visibleType = r100;
    }
}

package com.bytedance.ee.bear.bitable.card.viewmodel.share;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001LB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR$\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00106\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\u001e\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010@\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010F\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\u001a\u0010I\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams;", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "activity", "Landroidx/fragment/app/FragmentActivity;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "tableId", "", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "viewId", "getViewId", "setViewId", "bitableType", "getBitableType", "setBitableType", "recordId", "getRecordId", "setRecordId", "bitableShareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "getBitableShareMeta", "()Lcom/bytedance/ee/bear/share/IShareMeta;", "setBitableShareMeta", "(Lcom/bytedance/ee/bear/share/IShareMeta;)V", "bitableShareRecordInfo", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "getBitableShareRecordInfo", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "setBitableShareRecordInfo", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;)V", "formMode", "getFormMode", "setFormMode", "formEditable", "", "getFormEditable", "()Z", "setFormEditable", "(Z)V", "panelTitle", "getPanelTitle", "setPanelTitle", "panelComponents", "", "getPanelComponents", "()[Ljava/lang/String;", "setPanelComponents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "bannerURL", "getBannerURL", "setBannerURL", "bannerResId", "", "getBannerResId", "()Ljava/lang/Integer;", "setBannerResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "noticeMe", "getNoticeMe", "()Ljava/lang/Boolean;", "setNoticeMe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showNoticeMe", "getShowNoticeMe", "setShowNoticeMe", "showRemindMe", "getShowRemindMe", "setShowRemindMe", "BitableShareParamsBuilder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareParams extends ShareParams {
    private Integer bannerResId;
    private String bannerURL;
    private IShareMeta bitableShareMeta;
    private ShareRecordInfo bitableShareRecordInfo;
    private String bitableType;
    private boolean formEditable;
    private String formMode;
    private Boolean noticeMe;
    private String[] panelComponents;
    private String panelTitle;
    private String recordId;
    private boolean showNoticeMe;
    private boolean showRemindMe;
    private String tableId;
    private String viewId;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0018J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u001eJ\u0010\u0010#\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\tJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010L\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\tJ\u0019\u0010/\u001a\u00020\u00002\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\u0002\u0010OJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\tJ\u0015\u00109\u001a\u00020\u00002\b\u0010R\u001a\u0004\u0018\u00010:¢\u0006\u0002\u0010SJ\u0015\u0010@\u001a\u00020\u00002\b\u0010T\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010UJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010V\u001a\u00020'J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010V\u001a\u00020'J\b\u0010W\u001a\u00020XH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR$\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00106\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR\u001e\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010@\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010F\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\u001a\u0010I\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams$BitableShareParamsBuilder;", "Lcom/bytedance/ee/bear/share/export/ShareParams$ShareParamsBuilder;", "activity", "Landroidx/fragment/app/FragmentActivity;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/fragment/app/Fragment;)V", "tableId", "", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "viewId", "getViewId", "setViewId", "bitableType", "getBitableType", "setBitableType", "recordId", "getRecordId", "setRecordId", "bitableShareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "getBitableShareMeta", "()Lcom/bytedance/ee/bear/share/IShareMeta;", "setBitableShareMeta", "(Lcom/bytedance/ee/bear/share/IShareMeta;)V", "bitableShareRecordInfo", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "getBitableShareRecordInfo", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "setBitableShareRecordInfo", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;)V", "formMode", "getFormMode", "setFormMode", "formEditable", "", "getFormEditable", "()Z", "setFormEditable", "(Z)V", "panelTitle", "getPanelTitle", "setPanelTitle", "panelComponents", "", "getPanelComponents", "()[Ljava/lang/String;", "setPanelComponents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "bannerURL", "getBannerURL", "setBannerURL", "bannerResId", "", "getBannerResId", "()Ljava/lang/Integer;", "setBannerResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "noticeMe", "getNoticeMe", "()Ljava/lang/Boolean;", "setNoticeMe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showNoticeMe", "getShowNoticeMe", "setShowNoticeMe", "showRemindMe", "getShowRemindMe", "setShowRemindMe", "value", "name", "components", "([Ljava/lang/String;)Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams$BitableShareParamsBuilder;", "bannerUrl", "url", "resId", "(Ljava/lang/Integer;)Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams$BitableShareParamsBuilder;", "notice", "(Ljava/lang/Boolean;)Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams$BitableShareParamsBuilder;", "show", "build", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/BitableShareParams;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BitableShareParamsBuilder extends ShareParams.ShareParamsBuilder {
        private Integer bannerResId;
        private String bannerURL;
        private IShareMeta bitableShareMeta;
        private ShareRecordInfo bitableShareRecordInfo;
        private String bitableType;
        private boolean formEditable;
        private String formMode;
        private Boolean noticeMe;
        private String[] panelComponents;
        private String panelTitle;
        private String recordId;
        private boolean showNoticeMe;
        private boolean showRemindMe;
        private String tableId;
        private String viewId;

        @Override // com.bytedance.ee.bear.share.export.ShareParams.ShareParamsBuilder
        public BitableShareParams build() {
            BitableShareParams r100 = new BitableShareParams(getActivity(), getSourceFragment());
            apply(r100);
            r100.setTableId(this.tableId);
            r100.setViewId(this.viewId);
            r100.setRecordId(this.recordId);
            r100.setBitableType(this.bitableType);
            r100.setBitableShareMeta(this.bitableShareMeta);
            r100.setBitableShareRecordInfo(this.bitableShareRecordInfo);
            r100.setFormMode(this.formMode);
            r100.setFormEditable(this.formEditable);
            r100.setPanelTitle(this.panelTitle);
            r100.setPanelComponents(this.panelComponents);
            r100.setBannerURL(this.bannerURL);
            r100.setBannerResId(this.bannerResId);
            r100.setNoticeMe(this.noticeMe);
            r100.setShowNoticeMe(this.showNoticeMe);
            r100.setShowRemindMe(this.showRemindMe);
            String[] r101 = this.panelComponents;
            if (r101 == null) goto L11;
            boolean r102 = false;
            if (r101 != null) goto L7;
        L9:
            if (r102 == false) goto L11;
            r100.setExpandAtInit(Boolean.TRUE);
            goto L11
        L7:
            if (ArraysKt.contains(r101, "notice") != true) goto L9;
            r102 = true;
        L11:
            return r100;
        }

        public final Integer getBannerResId() {
            return this.bannerResId;
        }

        public final String getBannerURL() {
            return this.bannerURL;
        }

        public final IShareMeta getBitableShareMeta() {
            return this.bitableShareMeta;
        }

        public final ShareRecordInfo getBitableShareRecordInfo() {
            return this.bitableShareRecordInfo;
        }

        public final String getBitableType() {
            return this.bitableType;
        }

        public final boolean getFormEditable() {
            return this.formEditable;
        }

        public final String getFormMode() {
            return this.formMode;
        }

        public final Boolean getNoticeMe() {
            return this.noticeMe;
        }

        public final String[] getPanelComponents() {
            return this.panelComponents;
        }

        public final String getPanelTitle() {
            return this.panelTitle;
        }

        public final String getRecordId() {
            return this.recordId;
        }

        public final boolean getShowNoticeMe() {
            return this.showNoticeMe;
        }

        public final boolean getShowRemindMe() {
            return this.showRemindMe;
        }

        public final String getTableId() {
            return this.tableId;
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.bytedance.ee.bear.share.export.ShareParams.ShareParamsBuilder
        public /* bridge */ /* synthetic */ ShareParams build() {
            return build();
        }

        public final BitableShareParamsBuilder bannerResId(Integer r100) {
            this.bannerResId = r100;
            return this;
        }

        public final BitableShareParamsBuilder bannerUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.bannerURL = r100;
            return this;
        }

        public final BitableShareParamsBuilder bitableShareMeta(IShareMeta r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.bitableShareMeta = r100;
            return this;
        }

        public final BitableShareParamsBuilder bitableShareRecordInfo(ShareRecordInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.bitableShareRecordInfo = r100;
            return this;
        }

        public final BitableShareParamsBuilder bitableType(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.bitableType = r100;
            return this;
        }

        public final BitableShareParamsBuilder formEditable(boolean r100) {
            this.formEditable = r100;
            return this;
        }

        public final BitableShareParamsBuilder formMode(String r100) {
            this.formMode = r100;
            return this;
        }

        public final BitableShareParamsBuilder noticeMe(Boolean r100) {
            this.noticeMe = r100;
            return this;
        }

        public final BitableShareParamsBuilder panelComponents(String[] r100) {
            Intrinsics.checkNotNullParameter(r100, "components");
            this.panelComponents = r100;
            return this;
        }

        public final BitableShareParamsBuilder panelTitle(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.panelTitle = r100;
            return this;
        }

        public final BitableShareParamsBuilder recordId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.recordId = r100;
            return this;
        }

        public final void setBannerResId(Integer r100) {
            this.bannerResId = r100;
        }

        public final void setBannerURL(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.bannerURL = r100;
        }

        public final void setBitableShareMeta(IShareMeta r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.bitableShareMeta = r100;
        }

        public final void setBitableShareRecordInfo(ShareRecordInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.bitableShareRecordInfo = r100;
        }

        public final void setBitableType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.bitableType = r100;
        }

        public final void setFormEditable(boolean r100) {
            this.formEditable = r100;
        }

        public final void setFormMode(String r100) {
            this.formMode = r100;
        }

        public final void setNoticeMe(Boolean r100) {
            this.noticeMe = r100;
        }

        public final void setPanelComponents(String[] r100) {
            this.panelComponents = r100;
        }

        public final void setPanelTitle(String r100) {
            this.panelTitle = r100;
        }

        public final void setRecordId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.recordId = r100;
        }

        public final void setShowNoticeMe(boolean r100) {
            this.showNoticeMe = r100;
        }

        public final void setShowRemindMe(boolean r100) {
            this.showRemindMe = r100;
        }

        public final void setTableId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tableId = r100;
        }

        public final void setViewId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.viewId = r100;
        }

        public final BitableShareParamsBuilder showNoticeMe(boolean r100) {
            this.showNoticeMe = r100;
            return this;
        }

        public final BitableShareParamsBuilder showRemindMe(boolean r100) {
            this.showRemindMe = r100;
            return this;
        }

        public final BitableShareParamsBuilder tableId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.tableId = r100;
            return this;
        }

        public final BitableShareParamsBuilder viewId(String r100) {
            if (r100 != null) goto L4;
            r100 = "";
        L4:
            this.viewId = r100;
            return this;
        }

        public BitableShareParamsBuilder(FragmentActivity r100, Fragment r110) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            super(r100, r110);
            this.tableId = "";
            this.viewId = "";
            this.bitableType = "";
            this.recordId = "";
            this.bitableShareMeta = new DefaultShareMeta();
            this.bitableShareRecordInfo = new ShareRecordInfo(false, false, false, false, false, 31, null);
            this.bannerURL = "";
        }

        public /* synthetic */ BitableShareParamsBuilder(FragmentActivity r100, Fragment r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101);
        }
    }

    public final Integer getBannerResId() {
        return this.bannerResId;
    }

    public final String getBannerURL() {
        return this.bannerURL;
    }

    public final IShareMeta getBitableShareMeta() {
        return this.bitableShareMeta;
    }

    public final ShareRecordInfo getBitableShareRecordInfo() {
        return this.bitableShareRecordInfo;
    }

    public final String getBitableType() {
        return this.bitableType;
    }

    public final boolean getFormEditable() {
        return this.formEditable;
    }

    public final String getFormMode() {
        return this.formMode;
    }

    public final Boolean getNoticeMe() {
        return this.noticeMe;
    }

    public final String[] getPanelComponents() {
        return this.panelComponents;
    }

    public final String getPanelTitle() {
        return this.panelTitle;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final boolean getShowNoticeMe() {
        return this.showNoticeMe;
    }

    public final boolean getShowRemindMe() {
        return this.showRemindMe;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setBannerResId(Integer r100) {
        this.bannerResId = r100;
    }

    public final void setBannerURL(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bannerURL = r100;
    }

    public final void setBitableShareMeta(IShareMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bitableShareMeta = r100;
    }

    public final void setBitableShareRecordInfo(ShareRecordInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bitableShareRecordInfo = r100;
    }

    public final void setBitableType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bitableType = r100;
    }

    public final void setFormEditable(boolean r100) {
        this.formEditable = r100;
    }

    public final void setFormMode(String r100) {
        this.formMode = r100;
    }

    public final void setNoticeMe(Boolean r100) {
        this.noticeMe = r100;
    }

    public final void setPanelComponents(String[] r100) {
        this.panelComponents = r100;
    }

    public final void setPanelTitle(String r100) {
        this.panelTitle = r100;
    }

    public final void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }

    public final void setShowNoticeMe(boolean r100) {
        this.showNoticeMe = r100;
    }

    public final void setShowRemindMe(boolean r100) {
        this.showRemindMe = r100;
    }

    public final void setTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewId = r100;
    }

    public BitableShareParams(FragmentActivity r100, Fragment r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, r110);
        this.tableId = "";
        this.viewId = "";
        this.bitableType = "";
        this.recordId = "";
        this.bitableShareMeta = new DefaultShareMeta();
        this.bitableShareRecordInfo = new ShareRecordInfo(false, false, false, false, false, 31, null);
        this.bannerURL = "";
    }

    public /* synthetic */ BitableShareParams(FragmentActivity r100, Fragment r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}

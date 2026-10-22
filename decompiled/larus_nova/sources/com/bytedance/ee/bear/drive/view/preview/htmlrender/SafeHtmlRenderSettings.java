package com.bytedance.ee.bear.drive.view.preview.htmlrender;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class SafeHtmlRenderSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f224878a = 0;

    @AppConfig(key = "a2ui_html_preview_config")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001dB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig;", "", "im", "Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "driveStrict", "driveRelaxed", "<init>", "(Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;)V", "getIm", "()Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "getDriveStrict", "getDriveRelaxed", "getCsp", "", "securityScene", "Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/RenderSecurityScene;", "defaultCsp", "hasCloudPolicy", "", "hasCloudPolicy$contentmanager_drive_impl_productionChinaRelease", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "HtmlSecurityPolicy", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SafeHtmlRenderConfig {

        @SerializedName("driveRelaxed")
        private final HtmlSecurityPolicy driveRelaxed;

        @SerializedName("driveStrict")
        private final HtmlSecurityPolicy driveStrict;

        /* JADX INFO: renamed from: im, reason: collision with root package name */
        @SerializedName("im")
        private final HtmlSecurityPolicy f224879im;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "", BdpAppEventConstant.SANDBOX, "", "csp", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSandbox", "()Ljava/lang/String;", "getCsp", "buildCsp", "defaultCsp", "buildCsp$contentmanager_drive_impl_productionChinaRelease", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class HtmlSecurityPolicy {

            @SerializedName("csp")
            private final String csp;

            @SerializedName(BdpAppEventConstant.SANDBOX)
            private final String sandbox;

            /* JADX WARN: Multi-variable type inference failed */
            public HtmlSecurityPolicy() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ HtmlSecurityPolicy copy$default(HtmlSecurityPolicy r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.sandbox;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.csp;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.sandbox;
            }

            public final String component2() {
                return this.csp;
            }

            public final HtmlSecurityPolicy copy(String r100, String r101) {
                return new HtmlSecurityPolicy(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof HtmlSecurityPolicy) == true) goto L8;
                return false;
            L8:
                HtmlSecurityPolicy r101 = (HtmlSecurityPolicy) r100;
                if (Intrinsics.areEqual(this.sandbox, r101.sandbox) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.csp, r101.csp) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                String r100 = this.sandbox;
                int r101 = 0;
                if (r100 != null) goto L5;
                int r102 = 0;
            L6:
                int r103 = r102 * 31;
                String r104 = this.csp;
                if (r104 == null) goto L11;
                r101 = r104.hashCode();
            L11:
                return r103 + r101;
            L5:
                r102 = r100.hashCode();
                goto L6
            }

            public String toString() {
                return "HtmlSecurityPolicy(sandbox=" + this.sandbox + ", csp=" + this.csp + ')';
            }

            public final String getCsp() {
                return this.csp;
            }

            public final String getSandbox() {
                return this.sandbox;
            }

            public final String buildCsp$contentmanager_drive_impl_productionChinaRelease(String r100) {
                Intrinsics.checkNotNullParameter(r100, "defaultCsp");
                String r101 = this.csp;
                CharSequence r102 = "";
                boolean r103 = false;
                if (r101 == null) goto L22;
                String r104 = StringsKt.trim(r101).toString();
                if (r104 == null) goto L22;
                int r105 = r104.length() - 1;
                if (r105 < 0) goto L20;
            L8:
                int r106 = r105 - 1;
                char r107 = r104.charAt(r105);
                if (r107 != ';') goto L11;
            L14:
                boolean r108 = true;
            L15:
                if (r108 == false) goto L16;
                if (r106 < 0) goto L20;
                r105 = r106;
                goto L8
            L16:
                CharSequence r109 = r104.subSequence(0, r105 + 1);
            L21:
                String r110 = r109.toString();
            L23:
                if (r110 != null) goto L25;
            L28:
                boolean r111 = true;
            L29:
                if (r111 == false) goto L31;
                return r100;
            L31:
                String r112 = this.sandbox;
                if (r112 != null) goto L34;
                r112 = "";
            L34:
                String r113 = StringsKt.trim(r112).toString();
                int r114 = r113.length() - 1;
                if (r114 < 0) goto L48;
            L36:
                int r115 = r114 - 1;
                char r116 = r113.charAt(r114);
                if (r116 != ';') goto L39;
            L42:
                boolean r117 = true;
            L43:
                if (r117 == false) goto L44;
                if (r115 < 0) goto L48;
                r114 = r115;
                goto L36
            L44:
                r102 = r113.subSequence(0, r114 + 1);
                goto L48
            L39:
                if (CharsKt.isWhitespace(r116) == true) goto L42;
                r117 = false;
            L48:
                String r118 = r102.toString();
                if (r118.length() <= 0) goto L51;
                r103 = true;
            L51:
                if (r103 == false) goto L54;
                return "sandbox " + r118 + "; " + r110 + ';';
            L54:
                return "sandbox; " + r110 + ';';
            L25:
                if (r110.length() == 0) goto L28;
                r111 = false;
                goto L29
            L11:
                if (CharsKt.isWhitespace(r107) == true) goto L14;
                r108 = false;
            L20:
                r109 = "";
            L22:
                r110 = null;
                goto L23
            }

            public HtmlSecurityPolicy(String r100, String r101) {
                this.sandbox = r100;
                this.csp = r101;
            }

            public /* synthetic */ HtmlSecurityPolicy(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f224880a = null;

            static {
                int[] r100 = new int[RenderSecurityScene.values().length];
                r100[RenderSecurityScene.IM_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[RenderSecurityScene.DRIVE_NORMAL_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[RenderSecurityScene.DRIVE_DEGRADED_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f224880a = r100;
            }
        }

        public SafeHtmlRenderConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SafeHtmlRenderConfig copy$default(SafeHtmlRenderConfig r100, HtmlSecurityPolicy r101, HtmlSecurityPolicy r102, HtmlSecurityPolicy r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.f224879im;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.driveStrict;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.driveRelaxed;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final HtmlSecurityPolicy component1() {
            return this.f224879im;
        }

        public final HtmlSecurityPolicy component2() {
            return this.driveStrict;
        }

        public final HtmlSecurityPolicy component3() {
            return this.driveRelaxed;
        }

        public final SafeHtmlRenderConfig copy(HtmlSecurityPolicy r100, HtmlSecurityPolicy r101, HtmlSecurityPolicy r102) {
            return new SafeHtmlRenderConfig(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SafeHtmlRenderConfig) == true) goto L8;
            return false;
        L8:
            SafeHtmlRenderConfig r101 = (SafeHtmlRenderConfig) r100;
            if (Intrinsics.areEqual(this.f224879im, r101.f224879im) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.driveStrict, r101.driveStrict) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.driveRelaxed, r101.driveRelaxed) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            HtmlSecurityPolicy r100 = this.f224879im;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            HtmlSecurityPolicy r104 = this.driveStrict;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            HtmlSecurityPolicy r107 = this.driveRelaxed;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "SafeHtmlRenderConfig(im=" + this.f224879im + ", driveStrict=" + this.driveStrict + ", driveRelaxed=" + this.driveRelaxed + ')';
        }

        public final boolean hasCloudPolicy$contentmanager_drive_impl_productionChinaRelease() {
            HtmlSecurityPolicy r100 = this.f224879im;
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.getCsp();
        L7:
            if (r102 != null) goto L9;
        L12:
            boolean r103 = true;
        L13:
            if (r103 == false) goto L35;
            HtmlSecurityPolicy r104 = this.driveStrict;
            if (r104 == null) goto L17;
            String r105 = r104.getCsp();
        L18:
            if (r105 != null) goto L20;
        L23:
            boolean r106 = true;
        L24:
            if (r106 == false) goto L35;
            HtmlSecurityPolicy r107 = this.driveRelaxed;
            if (r107 == null) goto L28;
            r101 = r107.getCsp();
        L28:
            if (r101 != null) goto L30;
        L33:
            boolean r108 = true;
        L34:
            if (r108 == false) goto L35;
            return false;
        L30:
            if (r101.length() == 0) goto L33;
            r108 = false;
            goto L34
        L20:
            if (r105.length() == 0) goto L23;
            r106 = false;
            goto L24
        L17:
            r105 = null;
        L35:
            return true;
        L9:
            if (r102.length() == 0) goto L12;
            r103 = false;
            goto L13
        L5:
            r102 = null;
            goto L7
        }

        public final HtmlSecurityPolicy getDriveRelaxed() {
            return this.driveRelaxed;
        }

        public final HtmlSecurityPolicy getDriveStrict() {
            return this.driveStrict;
        }

        public final HtmlSecurityPolicy getIm() {
            return this.f224879im;
        }

        public final String getCsp(RenderSecurityScene r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "securityScene");
            Intrinsics.checkNotNullParameter(r101, "defaultCsp");
            int r102 = a.f224880a[r100.ordinal()];
            if (r102 != 1) goto L5;
            HtmlSecurityPolicy r103 = this.f224879im;
        L13:
            if (r103 == null) goto L19;
            String r104 = r103.buildCsp$contentmanager_drive_impl_productionChinaRelease(r101);
            if (r104 != null) goto L18;
            return r101;
        L18:
            return r104;
        L19:
            return r101;
        L5:
            if (r102 != 2) goto L7;
            r103 = this.driveRelaxed;
            goto L13
        L7:
            if (r102 != 3) goto L10;
            r103 = this.driveStrict;
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public SafeHtmlRenderConfig(HtmlSecurityPolicy r100, HtmlSecurityPolicy r101, HtmlSecurityPolicy r102) {
            this.f224879im = r100;
            this.driveStrict = r101;
            this.driveRelaxed = r102;
        }

        public /* synthetic */ SafeHtmlRenderConfig(HtmlSecurityPolicy r100, HtmlSecurityPolicy r101, HtmlSecurityPolicy r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    static {
    }
}

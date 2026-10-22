package com.bytedance.ee.bear.drive.view.preview.htmlrender;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SafeHtmlRenderSettings {
    public static final /* synthetic */ int a = 0;

    @AppConfig(key = "a2ui_html_preview_config")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001dB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig;", "", "im", "Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "driveStrict", "driveRelaxed", "<init>", "(Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;)V", "getIm", "()Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "getDriveStrict", "getDriveRelaxed", "getCsp", "", "securityScene", "Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/RenderSecurityScene;", "defaultCsp", "hasCloudPolicy", "", "hasCloudPolicy$contentmanager_drive_impl_productionChinaRelease", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "HtmlSecurityPolicy", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SafeHtmlRenderConfig {

        @SerializedName("driveRelaxed")
        private final HtmlSecurityPolicy driveRelaxed;

        @SerializedName("driveStrict")
        private final HtmlSecurityPolicy driveStrict;

        @SerializedName("im")
        private final HtmlSecurityPolicy im;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/htmlrender/SafeHtmlRenderSettings$SafeHtmlRenderConfig$HtmlSecurityPolicy;", "", "sandbox", "", "csp", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSandbox", "()Ljava/lang/String;", "getCsp", "buildCsp", "defaultCsp", "buildCsp$contentmanager_drive_impl_productionChinaRelease", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class HtmlSecurityPolicy {

            @SerializedName("csp")
            private final String csp;

            @SerializedName("sandbox")
            private final String sandbox;

            public HtmlSecurityPolicy() {
                String r0 = null;
                this(r0, r0, 3, r0);
            }

            public static /* synthetic */ HtmlSecurityPolicy copy$default(HtmlSecurityPolicy r0, String r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.sandbox;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.csp;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.sandbox;
            }

            public final String component2() {
                return this.csp;
            }

            public final HtmlSecurityPolicy copy(String r2, String r3) {
                return new HtmlSecurityPolicy(r2, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof HtmlSecurityPolicy) == true) goto L8;
                return false;
            L8:
                HtmlSecurityPolicy r6 = (HtmlSecurityPolicy) r5;
                if (Intrinsics.areEqual(this.sandbox, r6.sandbox) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.csp, r6.csp) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                String r0 = this.sandbox;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                String r4 = this.csp;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
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

            public final String buildCsp$contentmanager_drive_impl_productionChinaRelease(String r9) {
                Intrinsics.checkNotNullParameter(r9, "defaultCsp");
                String r0 = this.csp;
                CharSequence r1 = "";
                boolean r3 = false;
                if (r0 == null) goto L22;
                String r2 = StringsKt.trim(r0).toString();
                if (r2 == null) goto L22;
                int r5 = r2.length() - 1;
                if (r5 < 0) goto L20;
            L8:
                int r6 = r5 - 1;
                char r7 = r2.charAt(r5);
                if (r7 != ';') goto L11;
            L14:
                boolean r8 = true;
            L15:
                if (r8 == false) goto L16;
                if (r6 < 0) goto L20;
                r5 = r6;
                goto L8
            L16:
                CharSequence r4 = r2.subSequence(0, r5 + 1);
            L21:
                String r10 = r4.toString();
            L23:
                if (r10 != null) goto L25;
            L28:
                boolean r11 = true;
            L29:
                if (r11 == false) goto L31;
                return r9;
            L31:
                String r12 = this.sandbox;
                if (r12 != null) goto L34;
                r12 = "";
            L34:
                String r13 = StringsKt.trim(r12).toString();
                int r14 = r13.length() - 1;
                if (r14 < 0) goto L48;
            L36:
                int r16 = r14 - 1;
                char r17 = r13.charAt(r14);
                if (r17 != ';') goto L39;
            L42:
                boolean r18 = true;
            L43:
                if (r18 == false) goto L44;
                if (r16 < 0) goto L48;
                r14 = r16;
                goto L36
            L44:
                r1 = r13.subSequence(0, r14 + 1);
                goto L48
            L39:
                if (CharsKt.isWhitespace(r17) == true) goto L42;
                r18 = false;
            L48:
                String r19 = r1.toString();
                if (r19.length() <= 0) goto L51;
                r3 = true;
            L51:
                if (r3 == false) goto L54;
                return "sandbox " + r19 + "; " + r10 + ';';
            L54:
                return "sandbox; " + r10 + ';';
            L25:
                if (r10.length() == 0) goto L28;
                r11 = false;
                goto L29
            L11:
                if (CharsKt.isWhitespace(r7) == true) goto L14;
                r8 = false;
            L20:
                r4 = "";
            L22:
                r10 = null;
                goto L23
            }

            public HtmlSecurityPolicy(String r1, String r2) {
                this.sandbox = r1;
                this.csp = r2;
            }

            public /* synthetic */ HtmlSecurityPolicy(String r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RenderSecurityScene.values().length];
                r0[RenderSecurityScene.IM_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[RenderSecurityScene.DRIVE_NORMAL_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[RenderSecurityScene.DRIVE_DEGRADED_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public SafeHtmlRenderConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SafeHtmlRenderConfig copy$default(SafeHtmlRenderConfig r0, HtmlSecurityPolicy r1, HtmlSecurityPolicy r2, HtmlSecurityPolicy r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.im;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.driveStrict;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.driveRelaxed;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final HtmlSecurityPolicy component1() {
            return this.im;
        }

        public final HtmlSecurityPolicy component2() {
            return this.driveStrict;
        }

        public final HtmlSecurityPolicy component3() {
            return this.driveRelaxed;
        }

        public final SafeHtmlRenderConfig copy(HtmlSecurityPolicy r2, HtmlSecurityPolicy r3, HtmlSecurityPolicy r4) {
            return new SafeHtmlRenderConfig(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SafeHtmlRenderConfig) == true) goto L8;
            return false;
        L8:
            SafeHtmlRenderConfig r6 = (SafeHtmlRenderConfig) r5;
            if (Intrinsics.areEqual(this.im, r6.im) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.driveStrict, r6.driveStrict) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.driveRelaxed, r6.driveRelaxed) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            HtmlSecurityPolicy r0 = this.im;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            HtmlSecurityPolicy r4 = this.driveStrict;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            HtmlSecurityPolicy r7 = this.driveRelaxed;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SafeHtmlRenderConfig(im=" + this.im + ", driveStrict=" + this.driveStrict + ", driveRelaxed=" + this.driveRelaxed + ')';
        }

        public final boolean hasCloudPolicy$contentmanager_drive_impl_productionChinaRelease() {
            HtmlSecurityPolicy r0 = this.im;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.getCsp();
        L7:
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == false) goto L35;
            HtmlSecurityPolicy r4 = this.driveStrict;
            if (r4 == null) goto L17;
            String r5 = r4.getCsp();
        L18:
            if (r5 != null) goto L20;
        L23:
            boolean r6 = true;
        L24:
            if (r6 == false) goto L35;
            HtmlSecurityPolicy r7 = this.driveRelaxed;
            if (r7 == null) goto L28;
            r1 = r7.getCsp();
        L28:
            if (r1 != null) goto L30;
        L33:
            boolean r8 = true;
        L34:
            if (r8 == false) goto L35;
            return false;
        L30:
            if (r1.length() == 0) goto L33;
            r8 = false;
            goto L34
        L20:
            if (r5.length() == 0) goto L23;
            r6 = false;
            goto L24
        L17:
            r5 = null;
        L35:
            return true;
        L9:
            if (r2.length() == 0) goto L12;
            r3 = false;
            goto L13
        L5:
            r2 = null;
            goto L7
        }

        public final HtmlSecurityPolicy getDriveRelaxed() {
            return this.driveRelaxed;
        }

        public final HtmlSecurityPolicy getDriveStrict() {
            return this.driveStrict;
        }

        public final HtmlSecurityPolicy getIm() {
            return this.im;
        }

        public final String getCsp(RenderSecurityScene r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "securityScene");
            Intrinsics.checkNotNullParameter(r3, "defaultCsp");
            int r4 = a.a[r2.ordinal()];
            if (r4 != 1) goto L5;
            HtmlSecurityPolicy r5 = this.im;
        L13:
            if (r5 == null) goto L19;
            String r6 = r5.buildCsp$contentmanager_drive_impl_productionChinaRelease(r3);
            if (r6 != null) goto L18;
            return r3;
        L18:
            return r6;
        L19:
            return r3;
        L5:
            if (r4 != 2) goto L7;
            r5 = this.driveRelaxed;
            goto L13
        L7:
            if (r4 != 3) goto L10;
            r5 = this.driveStrict;
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public SafeHtmlRenderConfig(HtmlSecurityPolicy r1, HtmlSecurityPolicy r2, HtmlSecurityPolicy r3) {
            this.im = r1;
            this.driveStrict = r2;
            this.driveRelaxed = r3;
        }

        public /* synthetic */ SafeHtmlRenderConfig(HtmlSecurityPolicy r2, HtmlSecurityPolicy r3, HtmlSecurityPolicy r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    static {
    }
}

package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "drive_ttoffice_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0005R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/config/fg/DriveOfficeConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "usePdf", "", "getUsePdf", "()Ljava/lang/Boolean;", "setUsePdf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useWord", "getUseWord", "setUseWord", "useExcel", "getUseExcel", "setUseExcel", "usePPT", "getUsePPT", "setUsePPT", "useOffice", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficeConfig implements NonProguard {
    private Boolean useExcel;
    private Boolean usePPT;
    private Boolean usePdf;
    private Boolean useWord;

    public final boolean useOffice() {
        Boolean r0 = this.useWord;
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        if (r1 == true) goto L17;
        Boolean r2 = this.usePPT;
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        if (r3 == true) goto L17;
        Boolean r4 = this.useExcel;
        if (r4 == null) goto L15;
        boolean r5 = r4.booleanValue();
    L16:
        if (r5 == true) goto L17;
        return false;
    L15:
        r5 = false;
        goto L16
    L10:
        r3 = false;
    L17:
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public DriveOfficeConfig() {
        Boolean r0 = Boolean.TRUE;
        this.usePdf = r0;
        this.useWord = r0;
        this.useExcel = r0;
        this.usePPT = r0;
    }

    public final Boolean getUseExcel() {
        return this.useExcel;
    }

    public final Boolean getUsePPT() {
        return this.usePPT;
    }

    public final Boolean getUsePdf() {
        return this.usePdf;
    }

    public final Boolean getUseWord() {
        return this.useWord;
    }

    public final void setUseExcel(Boolean r1) {
        this.useExcel = r1;
    }

    public final void setUsePPT(Boolean r1) {
        this.usePPT = r1;
    }

    public final void setUsePdf(Boolean r1) {
        this.usePdf = r1;
    }

    public final void setUseWord(Boolean r1) {
        this.useWord = r1;
    }
}

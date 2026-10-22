package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "drive_ttoffice_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0005R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/config/fg/DriveOfficeConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "usePdf", "", "getUsePdf", "()Ljava/lang/Boolean;", "setUsePdf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useWord", "getUseWord", "setUseWord", "useExcel", "getUseExcel", "setUseExcel", "usePPT", "getUsePPT", "setUsePPT", "useOffice", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveOfficeConfig implements NonProguard {
    private Boolean useExcel;
    private Boolean usePPT;
    private Boolean usePdf;
    private Boolean useWord;

    public final boolean useOffice() {
        Boolean r100 = this.useWord;
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        if (r101 == true) goto L17;
        Boolean r102 = this.usePPT;
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        if (r103 == true) goto L17;
        Boolean r104 = this.useExcel;
        if (r104 == null) goto L15;
        boolean r105 = r104.booleanValue();
    L16:
        if (r105 == true) goto L17;
        return false;
    L15:
        r105 = false;
        goto L16
    L10:
        r103 = false;
    L17:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public DriveOfficeConfig() {
        Boolean r100 = Boolean.TRUE;
        this.usePdf = r100;
        this.useWord = r100;
        this.useExcel = r100;
        this.usePPT = r100;
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

    public final void setUseExcel(Boolean r100) {
        this.useExcel = r100;
    }

    public final void setUsePPT(Boolean r100) {
        this.usePPT = r100;
    }

    public final void setUsePdf(Boolean r100) {
        this.usePdf = r100;
    }

    public final void setUseWord(Boolean r100) {
        this.useWord = r100;
    }
}

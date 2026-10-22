package com.bytedance.ee.bear.list.offlinecache;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import sbb.e;
import ww4.a;
import ya5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = "manual_offline_config")
public class ManualOfflineConfig implements NonProguard {
    private static volatile CCMConfig sCcmConfig;
    private static volatile boolean sIsSetChanged;
    private static volatile ManualOfflineConfig sManualOfflineConfig;
    private boolean bitable_enabled;
    private boolean doc_enabled;
    private boolean docx_enabled;
    private boolean drive_enabled;
    private boolean guide_enabled;
    private boolean manual_offline_enabled;
    private long manual_offline_suspend_time;
    private int manual_offline_watch_max_num;
    private boolean mindnote_enabled;
    private boolean sheet_enabled;
    private boolean slide_enabled;

    public static ManualOfflineConfig getConfig() {
        if (sManualOfflineConfig == null) goto L5;
    L14:
        sCcmConfig = ((a) org.koin.java.a.a(a.class)).a();
        return sManualOfflineConfig;
    L5:
        monitor-enter(ManualOfflineConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sManualOfflineConfig != null) goto L9;
        sManualOfflineConfig = (ManualOfflineConfig) c.a.a.c("manual_offline_config", ManualOfflineConfig.class, new ManualOfflineConfig());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ManualOfflineConfig.class);     // Catch: Throwable -> L11
        goto L14
    }

    public boolean isDrive_enabled() {
        if (((b) org.koin.java.a.a(b.class)).a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.drive_enabled == false) goto L7;
        return true;
    }

    public boolean isManual_offline_enabled() {
        if (sCcmConfig == null) goto L8;
        CCMConfig r0 = sCcmConfig;
        if (r0.e != null) goto L7;
        r0.e = new CCMConfig.SubConfig();
    L7:
        boolean r1 = r0.e.a;
    L10:
        if (this.manual_offline_enabled == false) goto L13;
        if (r1 == false) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = true;
        goto L10
    }

    public ManualOfflineConfig() {
        this.manual_offline_enabled = true;
        this.manual_offline_watch_max_num = 100;
        this.manual_offline_suspend_time = 3600000;
        this.doc_enabled = true;
        this.docx_enabled = true;
        this.drive_enabled = true;
        this.sheet_enabled = true;
    }

    public long getManual_offline_suspend_time() {
        return this.manual_offline_suspend_time;
    }

    public int getManual_offline_watch_max_num() {
        return this.manual_offline_watch_max_num;
    }

    public boolean isBitable_enabled() {
        return this.bitable_enabled;
    }

    public boolean isDoc_enabled() {
        return this.doc_enabled;
    }

    public boolean isGuide_enabled() {
        return this.guide_enabled;
    }

    public boolean isMindnote_enabled() {
        return this.mindnote_enabled;
    }

    public boolean isSheet_enabled() {
        return this.sheet_enabled;
    }

    public boolean isSlide_enabled() {
        return this.slide_enabled;
    }

    public static boolean isEnable(int r4) {
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        return false;
    L5:
        CCMConfig r0 = ((a) org.koin.java.a.a(a.class)).a();
        if (r0.e != null) goto L9;
        r0.e = new CCMConfig.SubConfig();
    L9:
        if (r0.e.a == true) goto L11;
        return false;
    L11:
        ManualOfflineConfig r1 = getConfig();
        if (r1.isManual_offline_enabled() == true) goto L15;
        return false;
    L15:
        if (r4 != e.g.b) goto L19;
        return r1.doc_enabled;
    L19:
        if (r4 != e.h.b) goto L23;
        return r1.sheet_enabled;
    L23:
        if (r4 != e.k.b) goto L27;
        return r1.mindnote_enabled;
    L27:
        if (r4 != e.l.b) goto L35;
        if (((b) org.koin.java.a.a(b.class)).a() == true) goto L31;
        return false;
    L31:
        if (r1.drive_enabled == false) goto L49;
        return true;
    L49:
        return false;
    L35:
        if (r4 != e.i.b) goto L38;
        return false;
    L38:
        if (r4 != e.n.b) goto L41;
        return false;
    L41:
        if (r4 == e.o.b) goto L43;
        return false;
    L43:
        if (r1.docx_enabled == true) goto L45;
        return false;
    L45:
        if (c.a.a.f("spacekit.mobile.docx_manual_offline_enabled") == false) goto L52;
        return true;
    L52:
        return false;
    }

    public void setBitable_enabled(boolean r1) {
        this.bitable_enabled = r1;
    }

    public void setDoc_enabled(boolean r1) {
        this.doc_enabled = r1;
    }

    public void setDrive_enabled(boolean r1) {
        this.drive_enabled = r1;
    }

    public void setGuide_enabled(boolean r1) {
        this.guide_enabled = r1;
    }

    public void setManual_offline_enabled(boolean r1) {
        this.manual_offline_enabled = r1;
    }

    public void setManual_offline_suspend_time(long r1) {
        this.manual_offline_suspend_time = r1;
    }

    public void setManual_offline_watch_max_num(int r1) {
        this.manual_offline_watch_max_num = r1;
    }

    public void setMindnote_enabled(boolean r1) {
        this.mindnote_enabled = r1;
    }

    public void setSheet_enabled(boolean r1) {
        this.sheet_enabled = r1;
    }

    public void setSlide_enabled(boolean r1) {
        this.slide_enabled = r1;
    }
}

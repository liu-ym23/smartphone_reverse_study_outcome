package com.larus.shortcuts.api;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J2\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH&¨\u0006\u0014"}, d2 = {"Lcom/larus/shortcuts/api/IShortcutsService;", "", "addDynamicShortcut", "", "needShowCamera", "", "canShowRealtime", "cvsID", "", "refreshDynamicShortcut", "snapshotDynamicShortcutConfig", "clearDynamicShortcut", "tryAddPinShortcut", "cvsName", "iconUrl", "isCallBot", "eventJson", "Lorg/json/JSONObject;", "tryDisablePinShortcut", "cvsdID", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShortcutsService {
    void a(String r100);

    void b();

    void c(String r100, String r101, String r102, boolean r103, JSONObject r104);

    void d();

    void e();

    void s0(boolean r100, boolean r101, String r102);
}

package com.larus.business.arc.api;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f319905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f319906b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f319907c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f319908d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Regex f319909e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Regex f319910f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Regex f319911g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Regex f319912h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Regex f319913i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Regex f319914j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f319915k = null;

    static {
        ArcFrameworkFailure[] r100 = ArcFrameworkFailure.values();
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(r100[r103].getCode());
        r103 = r103 + 1;
        goto L3
    L5:
        f319905a = CollectionsKt.listOf(new String[]{"tool_group", "tool_name", "biz_status", "failure_code", UniContext.KEY_OF_BIZ_CODE, "arc_duration_ms", "stage_prepare_start_offset_ms", "stage_prepare_end_offset_ms", "stage_execute_start_offset_ms", "stage_execute_end_offset_ms", "stage_finalize_start_offset_ms", "stage_finalize_end_offset_ms"});
        f319906b = new Regex("^\\+?[0-9][0-9(). -]{5,}[0-9]$");
        f319907c = new Regex("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");
        f319908d = new Regex("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        f319909e = new Regex("^[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}$");
        f319910f = new Regex("^[0-9a-fA-F]+$");
        f319911g = new Regex("^[A-Za-z0-9_-]+$");
        f319912h = new Regex("^(?:(?:AKIA|ASIA)[A-Z0-9]{16}|(?:gh[opusr]|github_pat)_[A-Za-z0-9_]{16,}|xox[baprs]-[A-Za-z0-9-]{10,}|(?:sk|pk)_(?:live|test)_[A-Za-z0-9_-]{8,})$");
        f319913i = new Regex("^(?i:https?|wss?|ftp|file|content):");
        f319914j = new Regex("^(?i:token|password|passwd|secret|cookie|authorization|bearer|credential|verification_code)[:.-].+");
        f319915k = SetsKt.setOf(new String[]{"token", "password", "passwd", "secret", BaseHttpRequestInfo.KEY_COOKIE, "authorization", "bearer", "credential", "verification_code"});
    }
}

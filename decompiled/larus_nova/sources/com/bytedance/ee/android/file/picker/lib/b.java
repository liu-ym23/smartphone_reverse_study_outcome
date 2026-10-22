package com.bytedance.ee.android.file.picker.lib;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f205969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f205970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f205972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f205973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f205975g;

    public b() {
        this.f205969a = Long.MAX_VALUE;
        this.f205970b = Long.MAX_VALUE;
        this.f205971c = Integer.MAX_VALUE;
        this.f205972d = UIHelper.mustacheFormat(R.string.Lark_Message_File_defTitle);
        this.f205973e = UIHelper.getString(R.string.Lark_Legacy_Send);
        this.f205974f = false;
        this.f205975g = SetsKt.setOf(new String[]{"picker_video", "picker_doc", "picker_received"});
    }
}

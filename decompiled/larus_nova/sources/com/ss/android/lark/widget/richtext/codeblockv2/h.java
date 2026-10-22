package com.ss.android.lark.widget.richtext.codeblockv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<LineContent>> f448298a = null;

    static {
        f448298a = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(Context r100, List<LineContent> r101, CodeBlockV2ProcessParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lineContents");
        Intent r103 = new Intent(r100, CodeBlockV2DetailActivity.class);
        if ((r100 instanceof Activity) == true) goto L5;
        r103.addFlags(268435456);
    L5:
        String r104 = UUID.randomUUID().toString();
        f448298a.put(r104, r101);
        r103.putExtra("key_code_block_line_contents", r104);
        r103.putExtra("key_code_block_process_params", r102);
        r100.startActivity(r103);
    }
}

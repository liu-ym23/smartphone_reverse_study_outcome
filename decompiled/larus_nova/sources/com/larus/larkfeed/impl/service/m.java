package com.larus.larkfeed.impl.service;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Message> f355538a = null;

    static {
        f355538a = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.REF);
        f355538a.remove(r100);
    }
}

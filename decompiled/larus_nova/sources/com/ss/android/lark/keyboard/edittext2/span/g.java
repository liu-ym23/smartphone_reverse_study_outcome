package com.ss.android.lark.keyboard.edittext2.span;

import com.ss.android.lark.widget.richtext.LingoLocalExtraData;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f429216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, String> f429217b;

    public g() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.j
    public final void a(RichTextExtraInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "richTextExtraInfo");
        r100.setLingoLocalExtraData(new LingoLocalExtraData(this.f429216a, this.f429217b));
    }
}

package meb;

import com.google.gson.Gson;
import com.ss.android.lark.feed.molten.serializer.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f513580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f513581b;

    public a(Gson r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultGson");
        Intrinsics.checkNotNullParameter(r101, "uiFeedCardCodec");
        this.f513580a = r100;
        this.f513581b = r101;
    }
}

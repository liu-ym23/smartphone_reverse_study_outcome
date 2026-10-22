package sk;

import com.bytedance.android.ec.sdk.helper.q;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f542311a = null;

    public a() {
    }

    static {
        f542311a = new a();
    }

    public static List a(int r100) {
        return CollectionsKt.toMutableList(q.f48131a.a("resource_card_click_freq_" + r100, CollectionsKt.emptyList()));
    }

    public static List b(int r100) {
        return CollectionsKt.toMutableList(q.f48131a.a("resource_card_show_freq_" + r100, CollectionsKt.emptyList()));
    }
}

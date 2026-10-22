package meb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final meb.a f513582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<? extends UIFeedCard>> f513583b;

    public static final class a<T extends UIFeedCard> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f513584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f513585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b<T> f513586c;

        public a(Class r100, wh9.b r101) {
            Intrinsics.checkNotNullParameter("DouBaoConversationFeedCard", "runtimeTypeName");
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "adapter");
            this.f513584a = "DouBaoConversationFeedCard";
            this.f513585b = r100;
            this.f513586c = r101;
        }
    }

    public c(meb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "helpers");
        this.f513582a = r100;
        this.f513583b = new ArrayList();
    }
}

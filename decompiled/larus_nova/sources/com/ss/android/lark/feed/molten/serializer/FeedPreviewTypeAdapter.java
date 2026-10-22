package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "registry", "Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedPreviewTypeAdapter extends JsonTreeTypeAdapter<FeedPreview> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f421079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f421080b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421081a = null;

        static {
            int[] r100 = new int[PolymorphicFeedCardType.values().length];
            r100[PolymorphicFeedCardType.CHAT_FEED_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PolymorphicFeedCardType.THREAD_FEED_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f421081a = r100;
        }
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ FeedPreview a(JsonObject r100) {
        return c(r100);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(FeedPreview r100) {
        return d(r100);
    }

    public final FeedPreview c(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        PolymorphicFeedCardType r101 = e.a(r100);
        int r102 = a.f421081a[r101.ordinal()];
        ChatFeedPreviewTypeAdapter r103 = null;
        ThreadFeedPreviewTypeAdapter r104 = null;
        if (r102 != 1) goto L5;
        ChatFeedPreviewTypeAdapter r105 = this.f421080b.f421098b;
        if (r105 == null) goto L15;
        r103 = r105;
    L17:
        return r103.c(r100);
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L17
    L5:
        if (r102 == 2) goto L7;
        FeedPreview r106 = new FeedPreview();
        this.f421079a.a(r100, r106);
        return r106;
    L7:
        ThreadFeedPreviewTypeAdapter r107 = this.f421080b.f421099c;
        if (r107 == null) goto L10;
        r104 = r107;
    L19:
        return r104.c(r100);
    L10:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L19
    }

    public final JsonObject d(FeedPreview r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ThreadFeedPreviewTypeAdapter r101 = null;
        ChatFeedPreviewTypeAdapter r102 = null;
        if ((r100 instanceof ChatFeedPreview) == false) goto L10;
        ChatFeedPreviewTypeAdapter r103 = this.f421080b.f421098b;
        if (r103 == null) goto L7;
        r102 = r103;
    L18:
        return r102.d((ChatFeedPreview) r100);
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L18
    L10:
        if ((r100 instanceof ThreadFeedPreview) == false) goto L16;
        ThreadFeedPreviewTypeAdapter r104 = this.f421080b.f421099c;
        if (r104 == null) goto L14;
        r101 = r104;
    L19:
        return r101.d((ThreadFeedPreview) r100);
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L19
    L16:
        JsonObject r105 = new JsonObject();
        e.b(r105, r100);
        this.f421079a.b(r105, r100);
        return r105;
    }

    public FeedPreviewTypeAdapter(c r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldCodec");
        Intrinsics.checkNotNullParameter(r101, "registry");
        this.f421079a = r100;
        this.f421080b = r101;
    }
}

package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedCardButtonTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/FeedCardButton;", "actionTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ActionType;", "buttonTypeAdapter", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ButtonType;", "<init>", "(Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardButtonTypeAdapter extends JsonTreeTypeAdapter<FeedCardButton> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<AppFeedCardButton.ActionType> f421077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<AppFeedCardButton.ButtonType> f421078b;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final FeedCardButton a(JsonObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        AppFeedCardButton.ActionType r100 = (AppFeedCardButton.ActionType) a.k(r110, ReportConstant.COMMON_ACTION_TYPE, this.f421077a);
        if (r100 != null) goto L7;
        int r101 = g.f421123a;
        Intrinsics.checkNotNullParameter(AppFeedCardButton.ActionType.class, "enumClass");
        r100 = (AppFeedCardButton.ActionType) g.a(AppFeedCardButton.ActionType.class, 0);
        if (r100 != null) goto L7;
        r100 = (AppFeedCardButton.ActionType) a.d(AppFeedCardButton.ActionType.class);
    L7:
        AppFeedCardButton.ActionType r102 = r100;
        AppFeedCardButton.ButtonType r103 = (AppFeedCardButton.ButtonType) a.k(r110, "buttonType", this.f421078b);
        if (r103 != null) goto L12;
        int r104 = g.f421123a;
        Intrinsics.checkNotNullParameter(AppFeedCardButton.ButtonType.class, "enumClass");
        r103 = (AppFeedCardButton.ButtonType) g.a(AppFeedCardButton.ButtonType.class, 0);
        if (r103 != null) goto L12;
        r103 = (AppFeedCardButton.ButtonType) a.d(AppFeedCardButton.ButtonType.class);
    L12:
        AppFeedCardButton.ButtonType r105 = r103;
        String r106 = a.l(r110, "id");
        if (r106 != null) goto L15;
        String r107 = "";
    L16:
        String r108 = a.l(r110, "url");
        if (r108 != null) goto L19;
        String r109 = "";
    L20:
        String r111 = a.l(r110, "text");
        if (r111 != null) goto L23;
        String r112 = "";
    L25:
        return new FeedCardButton(r107, r109, r102, r112, r105);
    L23:
        r112 = r111;
        goto L25
    L19:
        r109 = r108;
        goto L20
    L15:
        r107 = r106;
        goto L16
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(FeedCardButton r100) {
        FeedCardButton r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.j(r102, "id", r101.getId());
        a.j(r102, "url", r101.getUrl());
        a.i(r102, ReportConstant.COMMON_ACTION_TYPE, r101.getActionType(), this.f421077a);
        a.j(r102, "text", r101.getText());
        a.i(r102, "buttonType", r101.getButtonType(), this.f421078b);
        return r102;
    }

    public FeedCardButtonTypeAdapter(WireEnumTypeAdapter r100, WireEnumTypeAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, "actionTypeAdapter");
        Intrinsics.checkNotNullParameter(r101, "buttonTypeAdapter");
        this.f421077a = r100;
        this.f421078b = r101;
    }
}

package com.larus.bmhome.chat.camera.command;

import com.google.gson.reflect.TypeToken;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f297614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, SuggestedActionData> f297615b = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/camera/command/SuggestedActionCache$defaultSuggestedActionData$2$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/model/action/SuggestedActionData;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<SuggestedActionData> {
        public a() {
        }
    }

    static {
        f297614a = LazyKt.lazy(new u());
        f297615b = new LinkedHashMap();
    }

    public static SuggestedActionData a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L18;
        Intrinsics.checkNotNullParameter(r100, "botId");
        SuggestedActionData r102 = (SuggestedActionData) ((LinkedHashMap) f297615b).get(r100);
        if (r102 == null) goto L13;
        FLogger.f375446a.i("SuggestedActionCache", "hit memory cache");
        return r102;
    L13:
        SuggestedActionData r103 = bc8.e.f18592a.b(r100);
        if (r103 == null) goto L18;
        FLogger.f375446a.i("SuggestedActionCache", "hit disk cache");
        return r103;
    L18:
        return (SuggestedActionData) f297614a.getValue();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}

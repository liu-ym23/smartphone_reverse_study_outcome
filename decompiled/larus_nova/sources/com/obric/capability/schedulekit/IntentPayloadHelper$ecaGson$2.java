package com.obric.capability.schedulekit;

import android.net.Uri;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.entity.ExtraTypeAdapterFactory;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IntentPayloadHelper$ecaGson$2 extends Lambda implements Function0<Gson> {
    public static final IntentPayloadHelper$ecaGson$2 INSTANCE = null;

    static {
        INSTANCE = new IntentPayloadHelper$ecaGson$2();
    }

    public IntentPayloadHelper$ecaGson$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Gson invoke() {
        return new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }
}

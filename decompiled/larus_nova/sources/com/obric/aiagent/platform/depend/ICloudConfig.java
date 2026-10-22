package com.obric.aiagent.platform.depend;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s9a.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig;", "", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICloudConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f384983a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig$Companion;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/ICloudConfig;", "impl$delegate", "Lkotlin/Lazy;", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICloudConfig {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f384984b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<ICloudConfig> f384985c = null;

        private Companion() {
        }

        static {
            f384984b = new Companion();
            f384985c = LazyKt.lazy(new c());
        }

        @Override // com.obric.aiagent.platform.depend.ICloudConfig
        public final JSONObject a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            ICloudConfig r101 = f384985c.getValue();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.a(r100);
        }
    }

    static {
        f384983a = Companion.f384984b;
    }

    JSONObject a(String r100);
}

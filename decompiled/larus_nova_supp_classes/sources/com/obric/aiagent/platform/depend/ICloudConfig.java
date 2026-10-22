package com.obric.aiagent.platform.depend;

import android.util.EventsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import s9a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig;", XmlPullParser.NO_NAMESPACE, "getSettingsConfig", "Lorg/json/JSONObject;", "key", XmlPullParser.NO_NAMESPACE, "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface ICloudConfig {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig$Companion;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/ICloudConfig;", "impl$delegate", "Lkotlin/Lazy;", "getSettingsConfig", "Lorg/json/JSONObject;", "key", XmlPullParser.NO_NAMESPACE, "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion implements ICloudConfig {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<ICloudConfig> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new c());
        }

        @Override // com.obric.aiagent.platform.depend.ICloudConfig
        public final JSONObject a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            ICloudConfig r0 = c.getValue();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a(r2);
        }
    }

    static {
        a = Companion.b;
    }

    JSONObject a(String r1);
}

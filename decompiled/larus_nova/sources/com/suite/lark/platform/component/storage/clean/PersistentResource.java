package com.suite.lark.platform.component.storage.clean;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public interface PersistentResource extends f {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/PersistentResource$PersistentResourceAdapter;", "Lcom/google/gson/TypeAdapter;", "", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PersistentResourceAdapter extends TypeAdapter<List<? extends PersistentResource>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PersistentResourceAdapter f460599a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Gson f460600b = null;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f460601a = null;

            static {
                int[] r100 = new int[JsonToken.values().length];
                r100[JsonToken.BEGIN_OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f460601a = r100;
            }
        }

        static {
            f460599a = new PersistentResourceAdapter();
            f460600b = new Gson();
        }

        private PersistentResourceAdapter() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @Override // com.google.gson.TypeAdapter
        public final List<? extends PersistentResource> read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            ArrayList r101 = new ArrayList();
            r100.beginArray();
        L4:
            if (r100.hasNext() == false) goto L25;
            JsonToken r102 = r100.peek();
            if (r102 != null) goto L8;
            int r103 = -1;
        L10:
            if (r103 != 1) goto L4;
            r100.beginObject();
            String r104 = null;
        L13:
            if (r100.hasNext() == false) goto L24;
            String r105 = r100.nextName();
            if (Intrinsics.areEqual(r105, "type") == true) goto L16;
            if (Intrinsics.areEqual(r105, "value") == false) goto L13;
            Object r106 = f460600b.fromJson(r100, a(r104));     // Catch: Exception -> L21
            Intrinsics.checkNotNull(r106);     // Catch: Exception -> L21
            r101.add((PersistentResource) r106);
        L21:
            e = move-exception;
            throw new IllegalStateException(e);
        L16:
            r104 = r100.nextString();
        L24:
            r100.endObject();
            goto L4
        L8:
            r103 = a.f460601a[r102.ordinal()];
            goto L10
        L25:
            r100.endArray();
            return r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, List<? extends PersistentResource> r101) {
            List<? extends PersistentResource> r102 = r101;
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            r100.beginArray();
            if (r102 == null) goto L16;
            Iterator<? extends PersistentResource> r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L16;
            PersistentResource r104 = r103.next();
            if (r104 == null) goto L9;
            r100.beginObject();
            r100.name("type").value(r104.getClass().getName());
            r100.name("value");
            f460600b.toJson(r104, r104.getClass(), r100);     // Catch: Exception -> L13
            r100.endObject();
        L13:
            e = move-exception;
            throw new IllegalStateException(e);
        L9:
            r100.nullValue();
        L16:
            r100.endArray();
        }
    }
}

package com.bytedance.locallife.pdp.entity;

import aq6.f;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.common.experiment.b;
import com.bytedance.locallife.pdp.settings.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class GoodsDetailStringJsonAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f261387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f261388b;

    public static class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f261389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeToken<T> f261390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f261391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f261392d;

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r110) throws IOException {
            int r100 = a.f261393a[r110.peek().ordinal()];
            boolean r101 = true;
            if (r100 != 1) goto L5;
            r110.nextNull();
            return null;
        L5:
            if (r100 != 2) goto L7;
            long r102 = System.currentTimeMillis();
            String r111 = r110.nextString();
            boolean r103 = false;
        L24:
            e = move-exception;
            Object r104 = GsonProtectorUtils.fromJson(this.f261389a, r111, this.f261390b.getType());
            HostServiceUtilsKt.w0().ensureNotReachHere(e, "goodsdetail sonic json parse error:" + e.getMessage() + ",content:" + r111);
            rq6.a r112 = rq6.a.f538927a;
            StringBuilder r105 = new StringBuilder("sonic parse error:");
            r105.append(e.getMessage());
            r112.b("goods_detail_string_json_adapter", r105.toString());
            e.printStackTrace();
            Object r113 = (T) r104;
            boolean r106 = false;
        L26:
            rq6.a.f538927a.c("goods_detail_string_json_adapter", "goodsdetail parse useSimd:" + r103 + ",useSimdDiff:" + r106 + ",cost:" + (System.currentTimeMillis() - r102));
            return (T) r113;
        L10:
            if (this.f261391c == false) goto L13;
            r113 = (T) this.f261389a.fromJson(new kd.a(r111), this.f261390b.getType());
        L23:
            r106 = r103;
            r103 = r101;
            goto L26
        L13:
            if (this.f261392d == false) goto L20;
            this.f261389a.fromJson(new kd.a(r111), this.f261390b.getType());     // Catch: Exception -> L24
            Object r107 = this.f261389a.fromJson(r111, this.f261390b.getType());     // Catch: Exception -> L24
            int r108 = f.f15904a;     // Catch: Exception -> L24
            Map r109 = f.a(this.f261389a);     // Catch: Exception -> L24
            rq6.a r114 = rq6.a.f538927a;     // Catch: Exception -> L24
            r114.c("goods_detail_string_json_adapter", "sonic diff result:" + r109);     // Catch: Exception -> L24
            if (r109 != null) goto L17;
        L19:
            r113 = r107;
        L22:
            r103 = r101;
            r101 = false;
            goto L23
        L17:
            if (r109.size() <= 0) goto L19;
            r114.b("goods_detail_string_json_adapter", "diffResult:" + r109);     // Catch: Exception -> L24
            HostServiceUtilsKt.w0().ensureNotReachHere(new Throwable("diffResult not equal"), "goodsdetail sonic json diff error,diffResult:" + r109 + "\ncontent:" + r111);     // Catch: Exception -> L24
            goto L19
        L20:
            r113 = this.f261389a.fromJson(r111, this.f261390b.getType());     // Catch: Exception -> L24
            r101 = false;
            goto L22
        L7:
            return (T) GsonProtectorUtils.fromJson(this.f261389a, r110, this.f261390b.getType());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, T r101) throws IOException {
            r100.value(GsonProtectorUtils.toJson(this.f261389a, r101));
        }

        public Adapter(Gson r100, TypeToken<T> r101, boolean r102, boolean r103) {
            this.f261389a = r100;
            this.f261390b = r101;
            this.f261391c = r102;
            this.f261392d = r103;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f261393a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f261393a = r100;
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f261393a[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public GoodsDetailStringJsonAdapterFactory() {
        this.f261387a = b.a();
        this.f261388b = b.b();
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        int r102 = w.f261753a;
        boolean r103 = false;
        if (HostServiceUtilsKt.y().b("goods_detail_migrate_data_parse", 0) != 1) goto L5;
        r103 = true;
    L5:
        if (r103 == false) goto L9;
        return null;
    L9:
        return new Adapter(r100, r101, this.f261387a, this.f261388b);
    }
}

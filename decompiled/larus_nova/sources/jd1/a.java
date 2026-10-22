package jd1;

import com.bytedance.android.livedress.impl.jsb.GetDressInfoDataSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(GetDressInfoDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ljd1/a;", "Lvh7/j;", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: jd1.a$a, reason: collision with other inner class name */
    @JsonAdapter(GetDressInfoDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C6415a {
    }

    @FieldName(name = "dressInfoString#setter")
    void e6(String r100);

    @FieldName(name = "dressInfo#setter")
    void h3(JsonObject r100);
}

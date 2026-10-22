package qea;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pea.c;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f532706a;

    /* JADX INFO: renamed from: qea.a$a, reason: collision with other inner class name */
    public static final class C7318a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f532706a, ((a) r100).f532706a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f532706a.hashCode();
    }

    public final String toString() {
        return "GRSmallCollapseTemplate(picInfo=" + this.f532706a + ')';
    }

    @Override // pea.l
    public final Bundle getActions() {
        return new Bundle();
    }

    @Override // pea.l
    public final Bundle getPics() {
        Bundle r100 = new Bundle();
        r100.putParcelable(this.f532706a.f528746b, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), this.f532706a.f528747c));
        FLogger.f375446a.d("GRSmallCollapseTemplate", "getPics: " + r100);
        return r100;
    }

    @Override // pea.l
    public final JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        r100.put("picInfo", this.f532706a.a());
        return r100;
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "picInfo");
        this.f532706a = r100;
    }

    @Override // pea.l
    public final k create(Boolean r100) {
        return new k("com.obric.island_assistant:gr_common_small_collapse_template", this, r100);
    }
}

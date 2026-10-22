package tn5;

import an4.e;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.f;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements an4.a {
    public final Set<e> a;

    public final an4.d getGlobalDecoration() {
        return null;
    }

    public final Function1<String, Unit> getOnToolbarItemClickCallBack() {
        return new b();
    }

    public final Function1<ToolbarV2, Unit> getOnUpdateToolBarCallBack() {
        return new a();
    }

    public c() {
        HashSet r0 = new HashSet();
        this.a = r0;
        r0.add(new com.bytedance.ee.bear.slides.toolbar.factory.fontsize.d());
        r0.add(new f());
        r0.add(new com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.f());
    }

    public final Set<e> getItemFactorySet() {
        return this.a;
    }
}

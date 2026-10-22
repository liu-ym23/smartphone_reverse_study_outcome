package tn5;

import an4.e;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.f;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements an4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<e> f546874a;

    @Override // an4.a
    public final an4.d getGlobalDecoration() {
        return null;
    }

    @Override // an4.a
    public final Function1<String, Unit> getOnToolbarItemClickCallBack() {
        return new b();
    }

    @Override // an4.a
    public final Function1<ToolbarV2, Unit> getOnUpdateToolBarCallBack() {
        return new a();
    }

    public c() {
        HashSet r100 = new HashSet();
        this.f546874a = r100;
        r100.add(new com.bytedance.ee.bear.slides.toolbar.factory.fontsize.d());
        r100.add(new f());
        r100.add(new com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.f());
    }

    @Override // an4.a
    public final Set<e> getItemFactorySet() {
        return this.f546874a;
    }
}

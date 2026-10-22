package ip1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class a<T> implements lp1.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f495256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ElementType f495257b;

    @Override // lp1.b
    public final ArrayList<T> getChildren() {
        return this.f495256a;
    }

    @Override // lp1.b
    public final ElementType getElementType() {
        return this.f495257b;
    }

    public a(ElementType r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        this.f495257b = r100;
        this.f495256a = new ArrayList();
    }
}

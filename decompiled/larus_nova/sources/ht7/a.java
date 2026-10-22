package ht7;

import com.baidu.platform.comapi.map.MapController;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f487143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteArrayOutputStream f487144b;

    public a() {
        this.f487143a = new ArrayList();
        this.f487144b = new ByteArrayOutputStream();
    }

    public final void insert(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        ((ArrayList) this.f487143a).add(r100);
    }
}

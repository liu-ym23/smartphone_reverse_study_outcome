package com.larus.chat.gallery.api;

import android.app.Dialog;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f324124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f324125b;

    /* JADX INFO: renamed from: com.larus.chat.gallery.api.a$a, reason: collision with other inner class name */
    public static final class C4168a<T> implements Comparator {
        public C4168a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((AttachmentSnapshot) r100).getSelectedOrder()), Integer.valueOf(((AttachmentSnapshot) r101).getSelectedOrder()));
        }
    }

    public abstract boolean Oa(String r100);

    public abstract List<AttachmentSnapshot> Qa();

    @Override // com.larus.chat.gallery.api.n
    public abstract String a();

    @Override // com.larus.chat.gallery.api.q
    public Boolean n() {
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public String o() {
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public z p() {
        return null;
    }

    public boolean t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return false;
    }

    public a() {
        dr9.g r100 = dr9.g.f469794a;
        this.f324124a = dr9.g.e("preview-access");
        this.f324125b = dr9.g.e("preview-owner");
    }

    @Override // com.larus.chat.gallery.api.x
    public final w h() {
        List r100 = CollectionsKt.sortedWith(Qa(), new C4168a());
        if (r100.isEmpty() == true) goto L20;
        List r101 = r100;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        boolean r103 = true;
        if ((!((AttachmentSnapshot) r102.next()).canEnterSendPipeline()) == false) goto L11;
    L16:
        if (r103 == false) goto L19;
        return null;
    L19:
        return new w(r100, a(), null, null, null, null, null, 252);
    L15:
        r103 = false;
        goto L16
    L7:
        if (r101.isEmpty() == false) goto L9;
    L20:
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public final String j() {
        return this.f324125b;
    }

    @Override // com.larus.chat.gallery.api.q
    public String k() {
        return this.f324124a;
    }

    @Override // com.larus.chat.gallery.api.q
    public void c(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // com.larus.chat.gallery.api.q
    public PreviewSelectionLimit e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public String getTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public final InputDraftSnapshot i(String r210) {
        Intrinsics.checkNotNullParameter(r210, "sourceNodeId");
        String r100 = a();
        List<AttachmentSnapshot> r101 = Qa();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        AttachmentSnapshot r104 = (AttachmentSnapshot) r103.next();
        r102.add(AttachmentSnapshot.copy$default(r104, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.toMap(r104.getExtra()), 65535, null));
        goto L4
    L7:
        return new InputDraftSnapshot(r100, r102, r210, 0, 8, null);
    }

    @Override // com.larus.chat.gallery.api.q
    public PreviewSelectionLimit r(PreviewMediaType r100) {
        Intrinsics.checkNotNullParameter(r100, "mediaType");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        return true;
    }

    public a0 Pa(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "itemKey");
        int r102 = a0.f324126d;
        return a0.a.a(Oa(r100), SelectResultReason.NOT_SUPPORTED);
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean l(PreviewSourceAction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "itemKey");
        return false;
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean v(PreviewSourceAction r100, String r101, k0 r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "itemKey");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        return false;
    }
}

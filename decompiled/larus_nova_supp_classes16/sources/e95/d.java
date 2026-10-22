package e95;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.i;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b.InterfaceC0219b a;

    public d(ArchivePreviewView.b r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        DriveFilePath r11 = (DriveFilePath) r10;
        tt5.a.h("ArchiveTreeDataLoader", "extractFile() success");
        b.InterfaceC0219b r0 = this.a;
        Intrinsics.checkNotNull(r11);
        final ArchivePreviewView.b r1 = (ArchivePreviewView.b) r0;
        UserSession r2 = r1.a.b;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        z75.a.C0333a r3 = z75.a.a;
        Biz r4 = r11.getBiz();
        String r5 = r11.getRelativePath();
        String r8 = z75.a.a.a(r4, r5, null, r2).subPath(r11.getFileName()).getRealPath();
        LocalOpenEntity r12 = new LocalOpenEntity(ArchivePreviewView.access$900(r1.c).p, ArchivePreviewView.access$1000(r1.c).o, "", r1.b.a, com.bytedance.ee.util.io.a.c(r8), new ArrayList(), r8);
        Bundle r6 = new Bundle();
        r6.putBoolean("archive_inner_file", true);
        r12.setExtras(r6);
        ((i) org.koin.java.a.a(i.class)).c(r1.c.getView().getContext(), r12);
        ArchivePreviewView.access$100(r1.c).post(new d95.b(r1));
        r1.a("", true);
    }
}

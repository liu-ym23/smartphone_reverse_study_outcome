package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f563986a = null;

    static {
        f563986a = new g();
    }

    public g() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof NoteEntity) == false) goto L22;
        NoteEntity r101 = (NoteEntity) r100;
        int r102 = ((r101.getTitle().hashCode() + 0) * 31) + r101.getText().hashCode();
        FormatModeEnum r103 = r101.getFormatMode();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.name().hashCode();
    L7:
        String r104 = r101.getNoteFolder();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        int r105 = r102 * 31;
        if (r101.isFavorite() == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = r105 + r106;
        List<FileEntity> r108 = r101.getFiles();
        if (r108 == null) goto L17;
        r107 = (r107 * 31) + r108.hashCode();
    L17:
        List<RecordingEntity> r109 = r101.getRecordings();
        if (r109 != null) goto L20;
        return r107;
    L20:
        return (r107 * 31) + r109.hashCode();
    L13:
        r106 = 1237;
        goto L14
    L22:
        throw new IllegalStateException("Check failed.".toString());
    }
}

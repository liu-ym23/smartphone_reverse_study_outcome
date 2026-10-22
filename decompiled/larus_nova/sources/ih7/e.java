package ih7;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f489883b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f489884c = null;

    public e() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "exif_tag";
    }

    static {
        f489884c = new e();
        f489882a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH), Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_GET_DID), 100020});
        f489883b = CollectionsKt.listOf(new String[]{ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489882a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return r101;
    L14:
        Object r103 = r100[0];
        if ((r103 instanceof String) == false) goto L17;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_tag", r103)}));
    L17:
        return r101;
    L5:
        if (r100.length != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r104 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L12:
        return true;
    L11:
        if (CollectionsKt.contains(f489883b, r101.get("extra_parameter_tag")) == false) goto L12;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}

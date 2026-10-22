package com.ss.android.ugc.aweme.search.vision.result.abtest;

import com.ss.android.ugc.aweme.search.common.config.PhotoSearchConfig;
import com.ss.android.ugc.aweme.search.common.config.PhotoSearchConfigSettings;
import com.ss.android.ugc.aweme.search.common.config.V2700FullConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/abtest/PhotoSearchV2700UiExperiment;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchV2700UiExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PhotoSearchV2700UiExperiment f453677a = null;

    private PhotoSearchV2700UiExperiment() {
    }

    static {
        f453677a = new PhotoSearchV2700UiExperiment();
    }

    public static void a(String r100, String r101) {
        PhotoSearchConfigSettings.f451589c.getClass();
        PhotoSearchConfig r102 = PhotoSearchConfigSettings.f451587a;
        V2700FullConfig r103 = r102.getV2700UiOptConfig();
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L37;
        if (r101 != null) goto L11;
    L14:
        boolean r106 = true;
    L15:
        if (r106 == true) goto L22;
        V2700FullConfig r107 = r102.getV2700UiOptConfig();
        if (r107 == null) goto L22;
        ArrayList<String> r108 = r107.getPassedEntranceList();
        if (r108 == null) goto L22;
        boolean r109 = r108.contains(r101);
    L23:
        if (r109 == false) goto L25;
        return;
    L25:
        if (r100 != null) goto L27;
    L28:
        r104 = true;
    L29:
        if (r104 == true) goto L40;
        V2700FullConfig r110 = r102.getV2700UiOptConfig();
        if (r110 == null) goto L38;
        ArrayList<String> r111 = r110.getForbiddenChannelList();
        if (r111 == null) goto L39;
        r111.contains(r100);
        return;
    L39:
        return;
    L38:
        return;
    L40:
        return;
    L27:
        if (StringsKt.isBlank(r100) == false) goto L29;
    L22:
        r109 = false;
        goto L23
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r106 = false;
        goto L15
    L37:
        return;
    L5:
        if (r103.getEnable() != 1) goto L7;
        r105 = true;
        goto L8
    }
}

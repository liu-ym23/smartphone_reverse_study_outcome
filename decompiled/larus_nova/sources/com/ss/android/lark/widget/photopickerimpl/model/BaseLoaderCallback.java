package com.ss.android.lark.widget.photopickerimpl.model;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.loader.app.LoaderManager;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0004J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001aH\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0084\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006)"}, d2 = {"Lcom/ss/android/lark/widget/photopickerimpl/model/BaseLoaderCallback;", "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "Landroid/database/Cursor;", "<init>", "()V", "NOT_GIF", "", "getNOT_GIF", "()Ljava/lang/String;", "QUERY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getQUERY_URI", "()Landroid/net/Uri;", "ORDER_BY", "getORDER_BY", "SELECTION_ALL_ARGS", "", "getSELECTION_ALL_ARGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SELECTION", "getSELECTION", "SELECTION_NOT_GIF", "getSELECTION_NOT_GIF", "videoMaxS", "", "getVideoMaxS", "()J", "setVideoMaxS", "(J)V", "videoMinS", "getVideoMinS", "setVideoMinS", "getSelectionArgsForAllMediaCondition", "timeCondition", "isGif", "", "getDurationSelection", "exMaxLimit", "exMinLimit", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseLoaderCallback implements LoaderManager.LoaderCallbacks<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f447769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f447770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f447771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f447772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f447773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f447774f;

    public static String a() {
        StringBuilder r100 = new StringBuilder("((duration is NULL) OR ");
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        Locale r102 = Locale.CHINA;
        Object[] r103 = new Object[3];
        r103[0] = Long.valueOf(Math.max(0, 0));
        if (Math.max(0, 0) != 0) goto L5;
        String r104 = "";
    L6:
        r103[1] = r104;
        r103[2] = Long.MAX_VALUE;
        r100.append(String.format(r102, "(%d <%s duration and duration <= %d)", Arrays.copyOf(r103, 3)));
        r100.append(")");
        return r100.toString();
    L5:
        r104 = ContainerUtils.KEY_VALUE_DELIMITER;
        goto L6
    }

    public BaseLoaderCallback() {
        this.f447769a = "!='image/gif'";
        this.f447770b = MediaStore.Files.getContentUri("external");
        this.f447771c = "date_modified DESC";
        this.f447772d = new String[]{"1", "3"};
        this.f447773e = "media_type=? AND _size>0";
        this.f447774f = "media_type=? AND _size>0 AND mime_type!='image/gif'";
    }

    public final String b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "timeCondition");
        StringBuilder r102 = new StringBuilder("(media_type=?");
        if (r101 == false) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        r102.append(" OR media_type=? AND ");
        r102.append(r100);
        r102.append(") AND _size>0");
        return r102.toString();
    L5:
        r103 = " AND mime_type" + this.f447769a;
        goto L6
    }
}

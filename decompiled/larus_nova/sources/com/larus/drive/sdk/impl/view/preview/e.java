package com.larus.drive.sdk.impl.view.preview;

import androidx.fragment.app.Fragment;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f342304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f342305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DriveFileItem f342306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f342307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f342308e;

    public static final class a {
    }

    static {
    }

    public e(Fragment r100, DriveFileItem r101) {
        Intrinsics.checkNotNullParameter(r100, "parentFragment");
        this.f342304a = r100;
        this.f342305b = R.id.drive_preview_content_container;
        this.f342306c = r101;
        this.f342307d = "drive_preview_content_container";
    }
}

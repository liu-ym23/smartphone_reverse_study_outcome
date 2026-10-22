package com.larus.bmhome.chat.camera.command;

import android.content.Intent;
import android.net.Uri;
import com.larus.platform.model.action.SuggestedAction;
import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f297590a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f297591a = null;

        static {
            f297591a = new a();
        }

        public a() {
        }
    }

    static {
        f297590a = a.f297591a;
    }

    void b(SuggestedAction r100);

    Intent c(String r100, Uri r101);

    void d(boolean r100, List<?> r101);

    Intent e(Uri r100);
}

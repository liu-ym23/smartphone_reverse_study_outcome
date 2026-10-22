package com.larus.doc.impl.chat;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.larus.common.apphost.AppHost;
import com.larus.doc.impl.DocActivity;
import com.larus.doc.impl.DocFragment;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final Fragment a() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Exception -> L26
        if ((r100 instanceof AppCompatActivity) == false) goto L6;
        AppCompatActivity r101 = (AppCompatActivity) r100;     // Catch: Exception -> L26
    L8:
        if ((r101 instanceof DocActivity) == false) goto L31;
        Fragment r102 = ((DocActivity) r101).getSupportFragmentManager().findFragmentByTag("tag_doc_fragment");     // Catch: Exception -> L26
        if ((r102 instanceof DocFragment) == false) goto L32;
        Fragment r103 = ((DocFragment) r102).f330991h;     // Catch: Exception -> L26
        boolean r104 = true;
        if (r103 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L33;
        if (r103 == null) goto L22;
        if (r103.isDetached() == true) goto L22;
    L23:
        if (r104 == true) goto L25;
        return null;
    L25:
        return r103;
    L22:
        r104 = false;
        goto L23
    L33:
        return null;
    L14:
        if (r103.isAdded() != true) goto L16;
        r105 = true;
        goto L17
    L32:
        return null;
    L31:
        return null;
    L6:
        r101 = null;
    L26:
        e = move-exception;
        FLogger.f375446a.e("getDocChatFragment", "getDocChatFragment error: " + e.getMessage());
        return null;
    }

    public static final Fragment b() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if ((r100 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r101 = (AppCompatActivity) r100;
    L7:
        if ((r101 instanceof DocActivity) == true) goto L9;
        return null;
    L9:
        return ((DocActivity) r101).getSupportFragmentManager().findFragmentByTag("tag_doc_fragment");
    L5:
        r101 = null;
        goto L7
    }
}

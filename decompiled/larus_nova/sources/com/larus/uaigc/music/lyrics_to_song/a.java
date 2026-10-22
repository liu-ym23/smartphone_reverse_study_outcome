package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContentList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class a extends xc8.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f373686p = 0;

    public abstract void n(Message r100, q0 r101, wc9.e r102, boolean r103, MusicCreationContentList r104, Fragment r105);

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
    }
}

package com.larus.livetutor.impl.history;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes30.dex */
public final class w {
    public static final String a(long r100) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r100 * 1000));
    }
}

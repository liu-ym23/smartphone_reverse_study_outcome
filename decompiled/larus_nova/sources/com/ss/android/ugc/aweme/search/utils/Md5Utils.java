package com.ss.android.ugc.aweme.search.utils;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/Md5Utils;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class Md5Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Md5Utils f453414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f453415b = null;

    private Md5Utils() {
    }

    static {
        f453414a = new Md5Utils();
        f453415b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }
}

package com.ss.android.lark.vfs;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes38.dex */
public interface h {
    boolean A(VFSPath r100, VFSPath r101, boolean r102) throws IOException;

    VFSFile B(File r100);

    boolean C();

    VFSFile D(File r100, String r101);

    OutputStream E(File r100) throws IOException;

    VFSFile F(VFSPath r100);

    File G(String r100, boolean r101) throws IOException;

    VFSPath H(File r100, String r101);

    boolean createNewFile(VFSPath r100);

    boolean delete(VFSPath r100);

    boolean exists(VFSPath r100);

    VFSFile i(String r100);

    boolean isDirectory(VFSPath r100);

    boolean isFile(VFSPath r100);

    InputStream j(File r100) throws IOException;

    InputStream k(String r100) throws IOException;

    InputStream l(VFSPath r100) throws IOException;

    VFSFile[] listFiles(VFSPath r100);

    OutputStream m(String r100) throws IOException;

    boolean mkdirs(VFSPath r100);

    File n(File r100, boolean r101) throws IOException;

    File o(PolarisFileWrapper r100);

    File p(String r100);

    VFSPath q(Uri r100);

    File r(VFSPath r100, boolean r101) throws IOException;

    OutputStream s(VFSPath r100, boolean r101) throws IOException;

    long size(VFSPath r100);

    VFSPath t(File r100);

    VFSPath u(String r100, String r101);

    VFSFile v(String r100, String r101);

    byte[] w(VFSPath r100) throws IOException;

    File x(VFSPath r100);

    void y(VFSPath r100, byte[] r101) throws IOException;

    VFSPath z(String r100);
}

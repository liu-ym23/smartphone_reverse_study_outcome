package com.ss.android.ttve.common;

import android.opengl.GLES20;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f449841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f449842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f449843c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f449844a;

        public a(String r100, int r101) {
            int r102 = GLES20.glGetError();
            if (r102 == 0) goto L5;
            VELogUtil.e("TEProgramObject", "before glCreateShader, glError: " + r102);
        L5:
            int r103 = GLES20.glCreateShader(r101);
            int r104 = GLES20.glGetError();
            if (r104 == 0) goto L8;
            VELogUtil.e("TEProgramObject", "after glCreateShader, glError: " + r104);
        L8:
            if (r103 == 0) goto L15;
            GLES20.glShaderSource(r103, r100);
            GLES20.glCompileShader(r103);
            int r105 = GLES20.glGetError();
            if (r105 == 0) goto L12;
            VELogUtil.e("TEProgramObject", "after glCompileShader, glError: " + r105);
        L12:
            int[] r106 = {0};
            GLES20.glGetShaderiv(r103, 35713, r106, 0);
            if (r106[0] == 1) goto L15;
            VELogUtil.e("TEProgramObject", GLES20.glGetShaderInfoLog(r103));
            GLES20.glDeleteShader(r103);
            r103 = 0;
        L15:
            this.f449844a = r103;
            if (r103 != 0) goto L19;
            VELogUtil.e("TEProgramObject", "glCreateShader Failed!...");
            return;
        }
    }

    public final void a() {
        GLES20.glUseProgram(this.f449841a);
    }

    public c() {
        this.f449841a = GLES20.glCreateProgram();
    }

    public final int b(String r100) {
        int r101 = GLES20.glGetUniformLocation(this.f449841a, r100);
        if (r101 >= 0) goto L5;
        String.format("uniform name %s does not exist", new Object[]{r100});
    L5:
        return r101;
    }

    public final boolean c(String r100, String r101) {
        int r102 = this.f449841a;
        if (r102 != 0) goto L5;
        r102 = GLES20.glCreateProgram();
    L5:
        a r103 = this.f449842b;
        if (r103 == null) goto L11;
        int r104 = r103.f449844a;
        if (r104 == 0) goto L11;
        GLES20.glDeleteShader(r104);
        r103.f449844a = 0;
    L11:
        a r105 = this.f449843c;
        if (r105 == null) goto L17;
        int r106 = r105.f449844a;
        if (r106 == 0) goto L17;
        GLES20.glDeleteShader(r106);
        r105.f449844a = 0;
    L17:
        this.f449842b = new a(r100, 35633);
        this.f449843c = new a(r101, 35632);
        GLES20.glAttachShader(r102, this.f449842b.f449844a);
        GLES20.glAttachShader(r102, this.f449843c.f449844a);
        int r107 = GLES20.glGetError();
        int r108 = 0;
    L19:
        if (r108 >= 32) goto L29;
        if (r107 == 0) goto L29;
        switch(r107) {
            case 1280: goto L27;
            case 1281: goto L26;
            case 1282: goto L25;
            case 1283: goto L22;
            case 1284: goto L22;
            case 1285: goto L24;
            case 1286: goto L23;
            default: goto L22;
        };
    L22:
        String r109 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L28:
        String.format("After tag \"%s\" glGetError %s(0x%x) ", new Object[]{"AttachShaders...", r109, Integer.valueOf(r107)});
        r107 = GLES20.glGetError();
        r108 = r108 + 1;
        goto L19
    L23:
        r109 = "invalid framebuffer operation";
        goto L28
    L24:
        r109 = "out of memory";
        goto L28
    L25:
        r109 = "invalid operation";
        goto L28
    L26:
        r109 = "invalid value";
        goto L28
    L27:
        r109 = "invalid enum";
    L29:
        GLES20.glLinkProgram(r102);
        int[] r110 = {0};
        GLES20.glGetProgramiv(r102, 35714, r110, 0);
        a r111 = this.f449842b;
        int r112 = r111.f449844a;
        if (r112 == 0) goto L33;
        GLES20.glDeleteShader(r112);
        r111.f449844a = 0;
    L33:
        a r113 = this.f449843c;
        int r114 = r113.f449844a;
        if (r114 == 0) goto L37;
        GLES20.glDeleteShader(r114);
        r113.f449844a = 0;
    L37:
        this.f449842b = null;
        this.f449843c = null;
        if (r110[0] == 1) goto L40;
        GLES20.glGetProgramInfoLog(r102);
        return false;
    L40:
        int r115 = this.f449841a;
        if (r115 == r102) goto L44;
        if (r115 == 0) goto L44;
        GLES20.glDeleteProgram(r115);
    L44:
        this.f449841a = r102;
        return true;
    }
}

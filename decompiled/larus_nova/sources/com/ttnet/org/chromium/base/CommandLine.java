package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    private static final String TAG = "CommandLine";
    private static final AtomicReference<CommandLine> sCommandLine = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CommandLine$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class JavaCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        private HashMap<String, String> mSwitches;

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            ArrayList<String> r100 = this.mArgs;
            return (String[]) r100.toArray(new String[r100.size()]);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            return new HashMap(this.mSwitches);
        }

        static {
        }

        public JavaCommandLine(String[] r100) {
            super(null);
            this.mSwitches = new HashMap();
            ArrayList<String> r101 = new ArrayList();
            this.mArgs = r101;
            this.mArgsBegin = 1;
            if (r100 != null) goto L5;
        L10:
            r101.add("");
            return;
        L5:
            if (r100.length == 0) goto L10;
            String r102 = r100[0];
            if (r102 == null) goto L10;
            r101.add(r102);
            appendSwitchesInternal(r100, 1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r100) {
            appendSwitchWithValue(r100, null);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r100) {
            appendSwitchesInternal(r100, 0);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r100) {
            String r101 = this.mSwitches.get(r100);
            if (r101 != null) goto L5;
        L6:
            return null;
        L5:
            if (r101.isEmpty() == true) goto L6;
            return r101;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r100) {
            return this.mSwitches.containsKey(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r100) {
            this.mSwitches.remove(r100);
            String r101 = HttpClient.ENDFLAG + r100;
            int r102 = this.mArgsBegin - 1;
        L3:
            if (r102 <= 0) goto L10;
            if (((String) ListProtector.get(this.mArgs, r102)).equals(r101) == false) goto L7;
        L8:
            this.mArgsBegin--;
            ListProtector.remove(this.mArgs, r102);
        L9:
            r102 = r102 - 1;
            goto L3
        L7:
            if (((String) ListProtector.get(this.mArgs, r102)).startsWith(r101 + "=") == false) goto L9;
        }

        private void appendSwitchesInternal(String[] r100, int r110) {
            int r101 = r100.length;
            int r102 = 0;
            boolean r103 = true;
        L3:
            if (r102 >= r101) goto L20;
            String r104 = r100[r102];
            if (r110 <= 0) goto L8;
            r110 = r110 - 1;
        L19:
            r102 = r102 + 1;
            goto L3
        L8:
            if (r104.equals(HttpClient.ENDFLAG) == false) goto L10;
            r103 = false;
        L10:
            if (r103 == true) goto L12;
        L18:
            this.mArgs.add(r104);
            goto L19
        L12:
            if (r104.startsWith(HttpClient.ENDFLAG) == false) goto L18;
            String[] r105 = r104.split("=", 2);
            if (r105.length <= 1) goto L16;
            String r106 = r105[1];
        L17:
            appendSwitchWithValue(r105[0].substring(2), r106);
            goto L19
        L16:
            r106 = null;
            goto L17
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r100, String r101) {
            HashMap<String, String> r102 = this.mSwitches;
            if (r101 != null) goto L5;
            String r103 = "";
        L6:
            r102.put(r100, r103);
            String r104 = HttpClient.ENDFLAG + r100;
            if (r101 != null) goto L9;
        L11:
            ArrayList<String> r105 = this.mArgs;
            int r106 = this.mArgsBegin;
            this.mArgsBegin = r106 + 1;
            ListProtector.add(r105, r106, r104);
            return;
        L9:
            if (r101.isEmpty() == true) goto L11;
            r104 = r104 + "=" + r101;
            goto L11
        L5:
            r103 = r101;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String[] getCommandLineArguments() {
            return null;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            HashMap r100 = new HashMap();
            String[] r101 = CommandLineJni.get().getSwitchesFlattened();
            int r102 = 0;
        L4:
            if (r102 >= r101.length) goto L6;
            r100.put(r101[r102], r101[r102 + 1]);
            r102 = r102 + 2;
            goto L4
        L6:
            return r100;
        }

        static {
        }

        public NativeCommandLine(String[] r100) {
            super(null);
            CommandLineJni.get().init(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r100) {
            CommandLineJni.get().appendSwitch(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r100) {
            CommandLineJni.get().appendSwitchesAndArguments(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r100) {
            return CommandLineJni.get().getSwitchValue(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r100) {
            return CommandLineJni.get().hasSwitch(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r100) {
            CommandLineJni.get().removeSwitch(r100);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r100, String r101) {
            Natives r102 = CommandLineJni.get();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r102.appendSwitchWithValue(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface Natives {
        void appendSwitch(String r100);

        void appendSwitchWithValue(String r100, String r101);

        void appendSwitchesAndArguments(String[] r100);

        String getSwitchValue(String r100);

        String[] getSwitchesFlattened();

        boolean hasSwitch(String r100);

        void init(String[] r100);

        void removeSwitch(String r100);
    }

    private CommandLine() {
    }

    public static void reset() {
        setInstance(null);
    }

    public abstract void appendSwitch(String r100);

    public abstract void appendSwitchWithValue(String r100, String r101);

    public abstract void appendSwitchesAndArguments(String[] r100);

    public void destroy() {
    }

    public abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String r100);

    public abstract Map getSwitches();

    public abstract boolean hasSwitch(String r100);

    public boolean isNativeImplementation() {
        return false;
    }

    public abstract void removeSwitch(String r100);

    static {
        sCommandLine = new AtomicReference();
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    public static String[] getJavaSwitchesOrNull() {
        CommandLine r100 = sCommandLine.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getCommandLineArguments();
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ CommandLine(AnonymousClass1 r100) {
        this();
    }

    public static void init(String[] r100) {
        setInstance(new JavaCommandLine(r100));
    }

    public static void initFromFile(String r100) {
        char[] r101 = readFileAsUtf8(r100);
        if (r101 != null) goto L5;
        String[] r102 = null;
    L6:
        init(r102);
        return;
    L5:
        r102 = tokenizeQuotedArguments(r101);
        goto L6
    }

    private static char[] readFileAsUtf8(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r101);     // Catch: IOException -> L13
        char[] r103 = new char[(int) r101.length()];     // Catch: Throwable -> L7
        char[] r104 = Arrays.copyOfRange(r103, 0, r102.read(r103));     // Catch: Throwable -> L7
        r102.close();     // Catch: IOException -> L13
        return r104;
    L7:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L13
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        return null;
    }

    private static void setInstance(CommandLine r100) {
        CommandLine r101 = sCommandLine.getAndSet(r100);
        if (r101 == null) goto L6;
        r101.destroy();
        return;
    }

    public static void setInstanceForTesting(CommandLine r100) {
        setInstance(r100);
    }

    public static String[] tokenizeQuotedArguments(char[] r110) {
        if (r110.length > 65536) goto L38;
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        StringBuilder r102 = null;
        int r103 = 0;
        char r104 = 0;
    L5:
        if (r103 >= r101) goto L31;
        char r105 = r110[r103];
        if (r104 == 0) goto L9;
    L12:
        if (r105 != r104) goto L22;
    L13:
        if (r102 != null) goto L15;
    L19:
        if (r104 != 0) goto L21;
        r104 = r105;
    L30:
        r103 = r103 + 1;
        goto L5
    L21:
        r104 = 0;
        goto L30
    L15:
        if (r102.length() <= 0) goto L19;
        if (r102.charAt(r102.length() - 1) != '\\') goto L19;
        r102.setCharAt(r102.length() - 1, r105);
        goto L30
    L22:
        if (r104 == 0) goto L24;
    L27:
        if (r102 != null) goto L29;
        r102 = new StringBuilder();
    L29:
        r102.append(r105);
        goto L30
    L24:
        if (Character.isWhitespace(r105) == false) goto L27;
        if (r102 == null) goto L30;
        r100.add(r102.toString());
        r102 = null;
        goto L30
    L9:
        if (r105 == '\'') goto L13;
        if (r105 == '\"') goto L13;
    L31:
        if (r102 == null) goto L36;
        if (r104 != 0) goto L34;
    L34:
        r100.add(r102.toString());
    L36:
        return (String[]) r100.toArray(new String[r100.size()]);
    L38:
        throw new RuntimeException("Flags file too big: " + r110.length);
    }

    public String getSwitchValue(String r100, String r101) {
        String r102 = getSwitchValue(r100);
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return r101;
    L6:
        return r102;
    }
}

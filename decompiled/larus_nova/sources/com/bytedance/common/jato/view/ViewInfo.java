package com.bytedance.common.jato.view;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public class ViewInfo {
    protected String activity;
    protected long attachedTime;
    protected long createTime;
    protected long detachedTime;
    protected Object extraInfo;
    protected long firstAttachedTime;
    protected int flags;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    protected int f202962id;
    protected InflateInfo inflateInfo;
    protected long lastLifeChangeTime;
    protected long lastLifeTimeDiff;
    protected String name;
    protected int notified;
    protected ViewState preState;
    protected long ptr;
    protected String scene;
    protected ViewState state;
    protected int threadId;
    protected String threadName;
    protected ViewInfoManager.InfoItem viewRef;

    /* JADX INFO: renamed from: com.bytedance.common.jato.view.ViewInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$common$jato$view$ViewState = null;

        static {
            int[] r100 = new int[ViewState.values().length];
            $SwitchMap$com$bytedance$common$jato$view$ViewState = r100;
            r100[ViewState.Attached.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$common$jato$view$ViewState[ViewState.Detached.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public View getView() {
        ViewInfoManager.InfoItem r100 = this.viewRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public boolean isFirstAttached() {
        if (this.firstAttachedTime != this.attachedTime) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        this.lastLifeChangeTime = 0;
        this.lastLifeTimeDiff = 0;
        this.createTime = 0;
        this.attachedTime = 0;
        this.firstAttachedTime = 0;
        this.detachedTime = 0;
        this.notified = 0;
        this.ptr = 0;
        ViewState r100 = ViewState.Unknown;
        this.state = r100;
        this.preState = r100;
        this.inflateInfo = null;
        this.viewRef = null;
        this.flags = 0;
        this.threadId = 0;
        this.activity = null;
        this.scene = null;
        this.threadName = null;
        this.extraInfo = null;
    }

    public String toString() {
        return "ViewInfo{id=" + this.f202962id + ", ptr=" + this.ptr + ", name='" + this.name + "', state=" + this.state + ", createTime=" + this.createTime + ", lastLifeChangeTime=" + this.lastLifeChangeTime + ", lastLifeTimeDiff=" + this.lastLifeTimeDiff + ", notified=" + this.notified + ", inflateInfo=" + this.inflateInfo + '}';
    }

    public ViewInfo() {
        ViewState r100 = ViewState.Unknown;
        this.state = r100;
        this.preState = r100;
    }

    public String getActivity() {
        return this.activity;
    }

    public long getAttachedTime() {
        return this.attachedTime;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getDetachedTime() {
        return this.detachedTime;
    }

    public int getId() {
        return this.f202962id;
    }

    public InflateInfo getInflateInfo() {
        return this.inflateInfo;
    }

    public String getName() {
        return this.name;
    }

    public long getPtr() {
        return this.ptr;
    }

    public String getScene() {
        return this.scene;
    }

    public ViewState getState() {
        return this.state;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public boolean hasFlag(int r100) {
        if ((r100 & this.flags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNotified(ViewState r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (((1 << r100.getValue()) & this.notified) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
        this.lastLifeChangeTime = r100;
    }

    public void setFlag(int r100) {
        this.flags = r100 | this.flags;
    }

    public void setId(int r100) {
        this.f202962id = r100;
    }

    public void setInflateInfo(InflateInfo r100) {
        this.inflateInfo = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPtr(long r100) {
        this.ptr = r100;
    }

    public void setThreadId(int r100) {
        this.threadId = r100;
    }

    public void setThreadName(String r100) {
        this.threadName = r100;
    }

    public void setViewRef(ViewInfoManager.InfoItem r100) {
        this.viewRef = r100;
    }

    public void onStateChange(ViewState r100, ViewState r101) {
        this.flags &= -65536;
    }

    public boolean setState(ViewState r100, long r110) {
        if (r100 == this.state) goto L26;
        if (r100 == null) goto L26;
        int r101 = 1 << r100.getValue();
        long r102 = this.lastLifeChangeTime;
        if (r102 == 0) goto L9;
        this.lastLifeTimeDiff = r110 - r102;
    L9:
        this.lastLifeChangeTime = r110;
        if (this.createTime != 0) goto L12;
        this.createTime = r110;
    L12:
        ViewState r103 = this.state;
        this.preState = r103;
        this.state = r100;
        onStateChange(r103, r100);
        int r104 = AnonymousClass1.$SwitchMap$com$bytedance$common$jato$view$ViewState[r100.ordinal()];
        if (r104 != 1) goto L15;
        this.attachedTime = r110;
        if (this.firstAttachedTime != 0) goto L21;
        this.firstAttachedTime = r110;
    L21:
        int r105 = this.notified;
        if ((r105 & r101) == 0) goto L24;
        return false;
    L24:
        this.notified = r105 | r101;
        return true;
    L15:
        if (r104 != 2) goto L21;
        this.detachedTime = r110;
    L26:
        return false;
    }
}

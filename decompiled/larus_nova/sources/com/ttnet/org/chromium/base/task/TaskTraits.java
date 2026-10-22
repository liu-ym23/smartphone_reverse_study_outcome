package com.ttnet.org.chromium.base.task;

import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public class TaskTraits {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TaskTraits BEST_EFFORT = null;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK = null;
    public static final TaskTraits CHOREOGRAPHER_FRAME = null;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final TaskTraits THREAD_POOL = null;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT = null;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING = null;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE = null;
    public static final TaskTraits USER_BLOCKING = null;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK = null;
    public static final TaskTraits USER_VISIBLE = null;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK = null;
    byte[] mExtensionData;
    byte mExtensionId;
    boolean mIsChoreographerFrame;
    boolean mMayBlock;
    int mPriority;
    boolean mUseThreadPool;

    static {
        TaskTraits r100 = new TaskTraits().taskPriority(0);
        BEST_EFFORT = r100;
        BEST_EFFORT_MAY_BLOCK = r100.mayBlock();
        TaskTraits r101 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = r101;
        USER_VISIBLE_MAY_BLOCK = r101.mayBlock();
        TaskTraits r102 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = r102;
        USER_BLOCKING_MAY_BLOCK = r102.mayBlock();
        TaskTraits r103 = new TaskTraits();
        CHOREOGRAPHER_FRAME = r103;
        r103.mIsChoreographerFrame = true;
        TaskTraits r104 = new TaskTraits().threadPool().taskPriority(2);
        THREAD_POOL = r104;
        THREAD_POOL_USER_BLOCKING = r104.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = r104.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = r104.taskPriority(0);
    }

    public boolean hasExtension() {
        if (this.mExtensionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return ((((((((((DataLoaderHelper.DATALOADER_KEY_INT_MIN_ALLOW_SPEED + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37) + Arrays.hashCode(this.mExtensionData)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits r100 = new TaskTraits(this);
        r100.mMayBlock = true;
        return r100;
    }

    public TaskTraits threadPool() {
        TaskTraits r100 = new TaskTraits(this);
        r100.mUseThreadPool = true;
        return r100;
    }

    public TaskTraits withExplicitDestination() {
        if (this.mUseThreadPool == false) goto L5;
    L8:
        return this;
    L5:
        if (hasExtension() == true) goto L8;
        return threadPool();
    }

    private TaskTraits() {
        this.mPriority = 2;
    }

    private TaskTraits(TaskTraits r100) {
        this.mPriority = r100.mPriority;
        this.mMayBlock = r100.mMayBlock;
        this.mUseThreadPool = r100.mUseThreadPool;
        this.mExtensionId = r100.mExtensionId;
        this.mExtensionData = r100.mExtensionData;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskTraits) == false) goto L22;
        TaskTraits r101 = (TaskTraits) r100;
        if (this.mPriority == r101.mPriority) goto L10;
    L20:
        return false;
    L10:
        if (this.mMayBlock != r101.mMayBlock) goto L20;
        if (this.mUseThreadPool != r101.mUseThreadPool) goto L20;
        if (this.mExtensionId != r101.mExtensionId) goto L20;
        if (Arrays.equals(this.mExtensionData, r101.mExtensionData) == false) goto L20;
        if (this.mIsChoreographerFrame != r101.mIsChoreographerFrame) goto L20;
        return true;
    L22:
        return false;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> r100) {
        if (this.mExtensionId == r100.getId()) goto L5;
        return null;
    L5:
        return r100.fromSerializedData(this.mExtensionData);
    }

    public TaskTraits taskPriority(int r100) {
        TaskTraits r101 = new TaskTraits(this);
        r101.mPriority = r100;
        return r101;
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> r100, Extension r101) {
        int r102 = r100.getId();
        byte[] r103 = r100.toSerializedData(r101);
        TaskTraits r104 = new TaskTraits(this);
        r104.mExtensionId = (byte) r102;
        r104.mExtensionData = r103;
        return r104;
    }
}

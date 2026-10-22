package com.ss.android.downloadlib.addownload.manager;

import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadInstallHelper extends PthreadAsyncTask<Void, Void, Void> {
    private DownloadInstallCallback mCallback;
    private List<DownloadInstallInfo> mQueryList;

    public interface DownloadInstallCallback {
        void onInstallQueryComplete(List<DownloadInstallInfo> r100);
    }

    public Void doInBackground(Void... r100) {
        List<DownloadInstallInfo> r101 = this.mQueryList;
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator<DownloadInstallInfo> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        DownloadInstallInfo r103 = r102.next();
        r103.setInstallStatus(ToolUtils.getInstalledAppStatus(r103.getAppPackageName(), r103.getVersionCode(), r103.getVersionName()));
        goto L7
    L9:
        return null;
    }

    public void onPostExecute(Void r100) {
        DownloadInstallCallback r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.onInstallQueryComplete(this.mQueryList);
        return;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
        return doInBackground((Void[]) r100);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
        onPostExecute((Void) r100);
    }

    public DownloadInstallHelper(List<DownloadInstallInfo> r100, DownloadInstallCallback r101) {
        this.mQueryList = r100;
        this.mCallback = r101;
    }
}

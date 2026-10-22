package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MediaBrowserCompatApi23 {

    public interface ItemCallback {
        void onError(String r1);

        void onItemLoaded(Parcel r1);
    }

    public static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T r1) {
            this.mItemCallback = r1;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String r2) {
            this.mItemCallback.onError(r2);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem r3) {
            if (r3 != null) goto L4;
            this.mItemCallback.onItemLoaded(null);
            return;
        L4:
            Parcel r0 = Parcel.obtain();
            r3.writeToParcel(r0, 0);
            this.mItemCallback.onItemLoaded(r0);
        }
    }

    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback r1) {
        return new ItemCallbackProxy(r1);
    }

    public static void getItem(Object r0, String r1, Object r2) {
        ((MediaBrowser) r0).getItem(r1, (MediaBrowser.ItemCallback) r2);
    }
}
